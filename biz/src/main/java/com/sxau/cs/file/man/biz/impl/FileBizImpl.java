package com.sxau.cs.file.man.biz.impl;

import com.google.common.collect.Lists;
import com.sxau.cs.file.man.biz.FileBiz;
import com.sxau.cs.file.man.biz.adaptor.FileInfoAdaptor;
import com.sxau.cs.file.man.common.constant.Constant;
import com.sxau.cs.file.man.common.model.request.FileCreateRequest;
import com.sxau.cs.file.man.common.model.request.FileListRequest;
import com.sxau.cs.file.man.common.model.request.FilePathRequest;
import com.sxau.cs.file.man.common.model.response.FileInfo;
import com.sxau.cs.file.man.common.model.response.FileInfoResponse;
import com.sxau.cs.file.man.common.model.response.FileListResponse;
import com.sxau.cs.file.man.service.FileService;
import com.sxau.cs.file.man.service.Impl.FileServiceImpl;
import com.sxau.cs.file.man.service.UserService;
import com.sxau.cs.file.man.service.bean.FileIdQueryCondition;
import com.sxau.cs.file.man.service.bean.FileInfoBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class FileBizImpl implements FileBiz {

    @Resource
    private FileService fileService;

    @Resource
    private UserService userService;

    public FileInfoResponse infoByPath(FilePathRequest filePathRequest) {
        String token = filePathRequest.getToken();
        Integer userId = userService.queryUserIdByToken(token);
        Assert.notNull(userId, "token非法");
        FileIdQueryCondition fileIdQueryCondition = new FileIdQueryCondition();
        long parentFileId = userService.queryFileIdByUserId(userId);
        List<String> fileNameList = parseFilePath(filePathRequest.getPath());
        for (String fileName : fileNameList) {
            fileIdQueryCondition.setParentId(parentFileId);
            fileIdQueryCondition.setName(fileName);
            Long fileId = fileService.queryFileIdByCondition(fileIdQueryCondition);
            if (fileId == null) throw new RuntimeException("文件不存在");
            parentFileId = fileId;
        }
        List<FileInfo> fileInfoList = fileService.queryInfosByFileIds(Lists.newArrayList(parentFileId));
        FileInfo fileInfo = fileInfoList.stream().filter(Objects::nonNull).findAny().orElse(null);
        FileInfoResponse fileInfoResponse = new FileInfoResponse();
        fileInfoResponse.setFileInfo(fileInfo);
        return fileInfoResponse;
    }

    public FileListResponse list(@RequestBody FileListRequest fileListRequest) {
        String token = fileListRequest.getToken();
        Integer userId = userService.queryUserIdByToken(token);
        Assert.notNull(userId, "token非法");

        Long parentFileId = fileListRequest.getFid();
        Assert.notNull(parentFileId, "文件id不能为空");
        List<Long> fileIdList = fileService.queryFileIdsByParentId(parentFileId);
        List<FileInfo> fileInfoList = fileService.queryInfosByFileIds(fileIdList);
        FileListResponse fileListResponse = new FileListResponse();
        fileListResponse.setRows(fileInfoList);
        fileListResponse.setStat(Constant.Stat.OK);
        return fileListResponse;
    }

    public FileInfoResponse createDir(FileCreateRequest fileCreateRequest) {
        String token = fileCreateRequest.getToken();
        Integer userId = userService.queryUserIdByToken(token);
        Assert.notNull(userId, "token非法");

        String fileName = fileCreateRequest.getName();
        Assert.hasLength(fileCreateRequest.getName(), "文件名称不能为空");
        Assert.hasLength(fileCreateRequest.getParent(), "父文件id不能为空");
        long parentFileId = Long.parseLong(fileCreateRequest.getParent());
        FileInfo parentFileInfo = fileService.queryInfoByFileId(parentFileId);
        Assert.notNull(parentFileInfo, "父目录不存在");
        List<Long> fileIdList = fileService.queryFileIdsByParentId(parentFileId);
        Assert.isTrue(fileService.queryInfosByFileIds(fileIdList).stream().filter(Objects::nonNull)
                .noneMatch(x -> fileName.equals(x.getName())), "文件不能重名");
        FileInfoBean fileInfoBean = new FileInfoBean();
        fileInfoBean.setName(fileName);
        fileInfoBean.setCreator(String.valueOf(userId));
        fileInfoBean.setEditor(StringUtils.EMPTY);
        fileService.insertFileInfo(fileInfoBean);
        FileInfoResponse fileInfoResponse = new FileInfoResponse();
        fileInfoResponse.setStat(Constant.Stat.OK);
        fileInfoResponse.setFileInfo(FileInfoAdaptor.fileInfoBean2FileInfo(fileInfoBean));
        return fileInfoResponse;
    }

    @Override
    public void download(Long fileId, String token) {
        Integer userId = userService.queryUserIdByToken(token);
        FileInfo fileInfo = fileService.queryInfoByFileId(fileId);
        if (!userService.tokenVerification(token) || userId == null) {
            System.out.println("FileDownload token失效/用户不存在");
            throw new RuntimeException("FileDownload token失效");
        } else if (fileInfo == null || fileInfo.getAttr() == 1) {
            System.out.println("FileDownload 下载目录不存在/下载非文件");
            throw new RuntimeException("FileDownload 下载目录不存在/下载非文件");
        }
        Long rootFileId = userService.queryFileIdByUserId(userId);
        FileIdQueryCondition fileIdQueryCondition = new FileIdQueryCondition();
        fileIdQueryCondition.setParentId(fileId);
        Long fileIdFound = fileService.queryFileIdByCondition(fileIdQueryCondition);
//        FileInfo fileInfo1;
//        Long fidNow = Long.valueOf(fileId)
//        do {
//            fileInfo1 = fileService.queryInfoByFileId(Long.valueOf(fidNow));
//        } while (fileInfo1.getParent() != null);
//        if (fileInfo1.getFid() != fileId2) {
//            System.out.println("");
//            return null;
//        }
        //判断fileIdFound是否对应rootFileId
        if (!rootFileId.equals(fileIdFound)) {
            System.out.println("FileDownload 文件数据读取失败");
            throw new RuntimeException("FileDownload 文件数据读取失败");
        }
        //todo 下载文件

        downloadFile(fileId);
    }


    /**
     * @param filePath 文件路径 /dev/code/
     * @return list of file names
     */
    private List<String> parseFilePath(String filePath) {
        Assert.hasLength(filePath, "文件路径不能为空");
        Assert.isTrue(filePath.startsWith("/"), "文件路径没有以根目录开头");
        String path = filePath.substring(1, filePath.length());
        //todo 待测试
        String[] names = path.split("/");
        //todo asList
        return Arrays.asList(names);
    }

    public void downloadFile(Long fileId) {
        FileService fileService = new FileServiceImpl();
        FileInfo fileInfo = fileService.queryInfoByFileId(fileId);
        if (fileInfo.getAttr() == 1) {
            System.out.println("FileDownload 下载目标非文件");
            throw new RuntimeException("FileDownload 下载目标非文件");
        }


        System.out.println("下载成功");
    }
}
