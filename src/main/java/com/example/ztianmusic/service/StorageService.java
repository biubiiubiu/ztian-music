package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.FileUploadDto;

import java.io.IOException;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:37
 */
public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}
