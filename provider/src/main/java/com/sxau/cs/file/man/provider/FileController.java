package com.sxau.cs.file.man.provider;

import com.sxau.cs.file.man.biz.FileBiz;
import com.sxau.cs.file.man.common.model.request.FileCreateRequest;
import com.sxau.cs.file.man.common.model.request.FileListRequest;
import com.sxau.cs.file.man.common.model.request.FilePathRequest;
import com.sxau.cs.file.man.common.model.response.FileInfoResponse;
import com.sxau.cs.file.man.common.model.response.FileListResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class FileController {

    @Resource
    private FileBiz fileBiz;

    @RequestMapping("/infoByPath")
    public FileInfoResponse infoByPath(@RequestBody FilePathRequest filePathRequest) {
        return fileBiz.infoByPath(filePathRequest);
    }

    @RequestMapping("/list")
    public FileListResponse list(@RequestBody FileListRequest fileListRequest) {
        return fileBiz.list(fileListRequest);
    }

    @RequestMapping("/createDir")
    public FileInfoResponse createDir(@RequestBody FileCreateRequest fileCreateRequest) {
        return fileBiz.createDir(fileCreateRequest);
    }

    @GetMapping("/download")
    public void download(@RequestParam Long fid, @RequestParam String token) {
        fileBiz.download(fid, token);
    }

}
