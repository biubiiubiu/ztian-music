package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.FileDto;
import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.dto.FileUploadRequest;
import com.example.ztianmusic.enums.FileStatus;
import com.example.ztianmusic.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FileServiceTest {

    private FileService fileService;


    @Test
    void initUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getBucket());
        Assertions.assertNotNull(fileUploadDto.getRegion());
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    void finishUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(), finishedFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getStatus());
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}