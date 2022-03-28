package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.SiteSettingDto;
import com.example.ztianmusic.service.FileService;
import com.example.ztianmusic.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 17:00
 */
@Service
public class SettingServiceImpl implements SettingService {

    @Value("${cos.bucket}")
    private String bucket;


    @Value("${cos.region}")
    private String region;


    private FileService fileService;


    @Override
    public SiteSettingDto getSiteSetting() {
        SiteSettingDto siteSettingDto = new SiteSettingDto();
        siteSettingDto.setBucket(bucket);
        siteSettingDto.setRegion(region);
        siteSettingDto.setStorage(fileService.getDefaultStorage());
        return siteSettingDto;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
