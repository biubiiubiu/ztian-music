package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.SiteSettingDto;
import com.example.ztianmusic.enums.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SettingServiceTest {

    private SettingService service;

    @Test
    void getSiteSetting() {
        SiteSettingDto siteSettingDto = service.getSiteSetting();
        Assertions.assertNotNull(siteSettingDto.getBucket());
        Assertions.assertNotNull(siteSettingDto.getRegion());
        Assertions.assertInstanceOf(Storage.class, siteSettingDto.getStorage());
    }

    @Autowired
    public void setService(SettingService service) {
        this.service = service;
    }
}