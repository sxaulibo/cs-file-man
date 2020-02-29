package com.sxau.cs.file.man.biz.adaptor;


import com.sxau.cs.file.man.common.model.response.FileInfo;
import com.sxau.cs.file.man.service.bean.FileInfoBean;

public class FileInfoAdaptor {

    public static FileInfo fileInfoBean2FileInfo(FileInfoBean fileInfoBean){
        return new FileInfo();
    }
}
