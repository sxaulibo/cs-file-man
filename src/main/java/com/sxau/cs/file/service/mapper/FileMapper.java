package com.sxau.cs.file.service.mapper;

import com.sxau.cs.file.provider.model.response.FileInfo;

import java.util.List;

public interface FileMapper {
    void insertFile(String name);

    List<FileInfo> list();
}