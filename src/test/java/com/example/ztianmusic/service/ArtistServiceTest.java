package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.*;
import com.example.ztianmusic.entity.User;
import com.example.ztianmusic.mapper.ArtistMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

@SpringBootTest
@Slf4j
class ArtistServiceTest extends BaseTest {

    @Autowired
    ArtistService artistService;

    @Autowired
    FileService fileService;

    @Autowired
    ArtistMapper artistMapper;

    private String photoId;


    @Test
    @WithMockUser(username = "ztian")
    void create() {
        ArtistCreateRequest artistCreateRequest = new ArtistCreateRequest();
        artistCreateRequest.setName("不是花火呀");
        artistCreateRequest.setRemark("不是花火呀");
        artistCreateRequest.setPhotoId("27I3h6Mm0Tl5HBKyEOIH3EycS3o");  // 测试图片
        UserDto user = userService.getCurrentUser();
        artistCreateRequest.setCreatedByUserId(user.getId());
        artistCreateRequest.setUpdatedByUserId(user.getId());
        ArtistDto artistDto1 = artistMapper.toDto(artistCreateRequest);
        ArtistDto artistDto = artistService.create(artistDto1);
        Assertions.assertEquals(artistCreateRequest.getName(), artistDto.getName());
        log.info(artistDto.toString());
    }

    @BeforeEach
    public void setDefaultPhoto() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("TA");
        fileUploadRequest.setExt("mp3");
        // certutil -hashfile  G:\广播台\TA.mp3 MD5
        fileUploadRequest.setKey("71ed659780a9f8a5e4bb9b88cbb1fe56");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        photoId = finishedFile.getId();
    }
}