package com.sxau.cs.file.biz.impl;

import com.sxau.cs.file.provider.model.request.BaseUserRequest;
import com.sxau.cs.file.provider.model.request.FileCreateRequest;
import com.sxau.cs.file.provider.model.request.FileListRequest;
import com.sxau.cs.file.provider.model.request.FilePathRequest;
import com.sxau.cs.file.provider.model.response.FileInfoResponse;
import com.sxau.cs.file.provider.model.response.FileListResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class FileBizImpl implements com.sxau.cs.file.biz.FileBiz {

    public FileInfoResponse infoByPath(FilePathRequest filePathRequest) {
        checkTokenProcess(filePathRequest.getToken());


        return null;
    }

    public FileListResponse list(@RequestBody FileListRequest fileListRequest) {
        checkTokenProcess(fileListRequest.getToken());
        return null;
    }

    public FileInfoResponse createDir(FileCreateRequest fileCreateRequest){
        checkTokenProcess(fileCreateRequest.getToken());
        return null;
    }

    private void checkTokenProcess(String token) {
        Assert.hasLength(token, "token不能为空");
        //todo Assert.isTrue(, "token校验不通过");
    }
}
