package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.FileDto;
import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.dto.FileUploadRequest;
import com.example.ztianmusic.enums.FileStatus;
import com.example.ztianmusic.enums.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FileServiceTest extends BaseService {

    private FileService fileService;


    @Test
    void initUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        // certutil -hashfile  F:\Chrome\DownloadFiles\ztianMusic.png MD5
        fileUploadRequest.setKey("8cdf28e57db9b4415b3e02de46221711");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }


    @Test
    void initUploadMaxSize() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("8cdf28e57db9b4415b3e02de46221711");
        fileUploadRequest.setSize(6082813636L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    @WithMockUser(username = "xcsh005")
    void finishUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("8cdf28e57db9b4415b3e02de46221711");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(), finishedFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getStatus());
    }


    @Test
    void getDefaultStorage() {
        Storage storage = fileService.getDefaultStorage();
        Assertions.assertEquals(Storage.COS, storage);
    }

    @Autowired
    private void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

}