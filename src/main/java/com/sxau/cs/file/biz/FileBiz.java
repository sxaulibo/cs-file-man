package com.sxau.cs.file.biz;

import com.sxau.cs.file.provider.model.request.BaseUserRequest;
import com.sxau.cs.file.provider.model.response.BaseResponse;
import com.sxau.cs.file.provider.model.response.FileInfoResponse;

/**
 * 文件业务类
 */
public interface FileBiz {

    /**
     * 查询文件(夹)路径信息
     *
     * @param baseUserRequest 用户基本请求
     * @return 文件(夹)信息
     */
    BaseResponse<FileInfoResponse> infoByPath(BaseUserRequest baseUserRequest);
}
