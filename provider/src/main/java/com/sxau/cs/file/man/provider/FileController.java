package com.sxau.cs.file.man.provider;

import com.sxau.cs.file.man.biz.FileBiz;
import com.sxau.cs.file.man.common.model.request.FileCreateRequest;
import com.sxau.cs.file.man.common.model.request.FileListRequest;
import com.sxau.cs.file.man.common.model.request.FilePathRequest;
import com.sxau.cs.file.man.common.model.response.FileInfoResponse;
import com.sxau.cs.file.man.common.model.response.FileListResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FileController {

    @Resource
    private FileBiz fileBiz;

    public FileInfoResponse infoByPath(@RequestBody FilePathRequest filePathRequest) {
        return fileBiz.infoByPath(filePathRequest);
    }

    public FileListResponse list(@RequestBody FileListRequest fileListRequest) {
        return fileBiz.list(fileListRequest);
    }

    public FileInfoResponse createDir(@RequestBody FileCreateRequest fileCreateRequest) {
        return fileBiz.createDir(fileCreateRequest);
    }

    public void download(@RequestParam Long fid, String token) {
        fileBiz.download(fid, token);
    }
}
