package com.sxau.cs.file.provider;

import com.sxau.cs.file.biz.FileBiz;
import com.sxau.cs.file.provider.model.request.FilePathRequest;
import com.sxau.cs.file.provider.model.response.BaseResponse;
import com.sxau.cs.file.provider.model.response.FileInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @Autowired
    private FileBiz fileBiz;

    @ResponseBody
    public BaseResponse<FileInfoResponse> infoByPath(@RequestBody FilePathRequest filePathRequest) {
        return fileBiz.infoByPath(filePathRequest);
    }
}
