package com.sxau.cs.file.service.Impl;

import com.google.common.collect.Lists;
import com.sxau.cs.file.man.common.model.response.FileInfo;
import com.sxau.cs.file.service.FileService;
import com.sxau.cs.file.service.bean.FileIdQueryCondition;
import com.sxau.cs.file.service.bean.FileInfoBean;
import com.sxau.cs.file.service.mapper.FileInfoMapper;
import com.sxau.cs.file.service.mapper.FileRelationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Resource
    FileInfoMapper fileInfoMapper;
    @Resource
    FileRelationMapper fileRelationMapper;

    public FileInfo queryInfoByFileId(long fileId) {
        return queryInfosByFileIds(Lists.newArrayList(fileId)).stream().findAny().orElse(null);
    }

    public List<FileInfo> queryInfosByFileIds(List<Long> fileId) {
        return fileInfoMapper.queryFileInfoListByFileIds(fileId);
    }

    public long insertFileInfo(FileInfoBean fileInfoBean) {
        return fileInfoMapper.insertFileInfo(fileInfoBean);
    }

    public Long queryFileIdByCondition(FileIdQueryCondition fileIdQueryCondition) {
        return fileRelationMapper.queryFileIdByCondition(fileIdQueryCondition);
    }

    public List<Long> queryFileIdsByParentId(long parentId) {
        return fileRelationMapper.queryFileIdListByParentId(parentId);
    }

    public FileInfo fileDownload(String fid) {
        return null;
    }

}
