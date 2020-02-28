package com.sxau.cs.file.service;

import com.sxau.cs.file.provider.model.response.FileInfo;
import com.sxau.cs.file.service.bean.FileIdQueryCondition;
import com.sxau.cs.file.service.bean.FileInfoBean;

import java.util.List;

/**
 * 文件服务
 */
public interface FileService {

    /**
     * 查询文件信息
     *
     * @param fileId 文件Id
     * @return 文件信息
     */
    FileInfo queryInfoByFileId(long fileId);

    /**
     * 批量查询文件信息
     *
     * @param fileIdList 文件Id列表
     * @return 文件信息列表
     */
    List<FileInfo> queryInfosByFileIds(List<Long> fileIdList);

    /**
     * 新建文件
     *
     * @param fileInfoBean 文件信息
     * @return 文件id
     */
    long insertFileInfo(FileInfoBean fileInfoBean);

    /**
     * 查询文件id
     *
     * @param fileIdQueryCondition 父文件id、文件名称
     * @return 文件id
     */
    Long queryFileIdByCondition(FileIdQueryCondition fileIdQueryCondition);

    /**
     * 查询子文件
     *
     * @param parentId 父文件id
     * @return 子文件id列表
     */
    List<Long> queryFileIdsByParentId(long parentId);

    File fileDownload(String fid);
}
