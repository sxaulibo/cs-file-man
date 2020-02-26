package com.sxau.cs.file.biz.adaptor;

import com.sxau.cs.file.provider.model.response.FileInfo;
import com.sxau.cs.file.service.bean.FileInfoBean;

public class FileInfoAdaptor {

    public static FileInfo fileInfoBean2FileInfo(FileInfoBean fileInfoBean){
        return new FileInfo();
    }
}
