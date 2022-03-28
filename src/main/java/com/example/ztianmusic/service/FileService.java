package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.FileDto;
import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.dto.FileUploadRequest;
import com.example.ztianmusic.enums.Storage;

import java.io.IOException;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:36
 */
public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();
}

