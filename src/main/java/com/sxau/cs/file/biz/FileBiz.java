package com.sxau.cs.file.biz;

import com.sxau.cs.file.provider.model.request.FileCreateRequest;
import com.sxau.cs.file.provider.model.request.FileListRequest;
import com.sxau.cs.file.provider.model.request.FilePathRequest;
import com.sxau.cs.file.provider.model.response.FileInfoResponse;
import com.sxau.cs.file.provider.model.response.FileListResponse;

/**
 * 文件业务类
 */
public interface FileBiz {

    /**
     * 查询文件(夹)路径信息
     *
     * @param filePathRequest 文件路径
     * @return 文件(夹)信息
     */
    FileInfoResponse infoByPath(FilePathRequest filePathRequest);

    /**
     * 列表
     *
     * @param fileListRequest 文件(夹)列表请求
     * @return 文件(夹)列表
     */
    FileListResponse list(FileListRequest fileListRequest);

    /**
     * 创建文件夹
     *
     * @param fileCreateRequest 文件创建请求
     * @return 文件(夹)信息
     */
    FileInfoResponse createDir(FileCreateRequest fileCreateRequest);
}
