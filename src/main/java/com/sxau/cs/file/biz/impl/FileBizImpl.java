package com.sxau.cs.file.biz.impl;

import com.sxau.cs.file.provider.model.request.BaseUserRequest;
import com.sxau.cs.file.provider.model.response.BaseResponse;
import com.sxau.cs.file.provider.model.response.FileInfoResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class FileBizImpl implements com.sxau.cs.file.biz.FileBiz {

    public BaseResponse<FileInfoResponse> infoByPath(BaseUserRequest baseUserRequest) {
        Assert.hasLength(baseUserRequest.getToken(), "token不能为空");
        return null;
    }
}
