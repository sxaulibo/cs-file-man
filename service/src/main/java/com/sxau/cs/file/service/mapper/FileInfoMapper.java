package com.sxau.cs.file.service.mapper;

import com.sxau.cs.file.provider.model.response.FileInfo;
import com.sxau.cs.file.service.bean.FileInfoBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文件信息
 */
@Repository
public interface FileInfoMapper {

    /**
     * 根据文件id查询文件信息
     *
     * @param fileIdList 文件id列表
     * @return 文件信息
     */
    List<FileInfo> queryFileInfoListByFileIds(List<Long> fileIdList);

    /**
     * 新建文件
     *
     * @param fileInfoBean 文件信息
     * @return 文件id
     */
    long insertFileInfo(FileInfoBean fileInfoBean);
}