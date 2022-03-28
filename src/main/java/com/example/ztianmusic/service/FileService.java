package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.dto.FileUploadRequest;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:36
 */
public interface FileService {

    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);
}
