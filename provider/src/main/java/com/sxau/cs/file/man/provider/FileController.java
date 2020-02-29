package com.sxau.cs.file.man.provider;

import com.sxau.cs.file.man.biz.FileBiz;
import com.sxau.cs.file.man.common.model.request.FileCreateRequest;
import com.sxau.cs.file.man.common.model.request.FileListRequest;
import com.sxau.cs.file.man.common.model.request.FilePathRequest;
import com.sxau.cs.file.man.common.model.response.FileDownloadResponse;
import com.sxau.cs.file.man.common.model.response.FileInfoResponse;
import com.sxau.cs.file.man.common.model.response.FileListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @Autowired
    private FileBiz fileBiz;

    @ResponseBody
    public FileInfoResponse infoByPath(@RequestBody FilePathRequest filePathRequest) {
        return fileBiz.infoByPath(filePathRequest);
    }

    @ResponseBody
    public FileListResponse list(@RequestBody FileListRequest fileListRequest) {
        return fileBiz.list(fileListRequest);
    }

    @ResponseBody
    public FileInfoResponse createDir(@RequestBody FileCreateRequest fileCreateRequest) {
        return fileBiz.createDir(fileCreateRequest);
    }

    @ResponseBody
    public FileDownloadResponse download(@RequestParam Long fid, String token) {
        return fileBiz.download(fid, token);
    }
}
