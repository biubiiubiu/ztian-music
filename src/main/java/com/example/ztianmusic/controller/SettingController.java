package com.example.ztianmusic.controller;

import com.example.ztianmusic.mapper.SiteSettingMapper;
import com.example.ztianmusic.service.SettingService;
import com.example.ztianmusic.vo.SiteSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: setting controller
 *
 * @author: zhangtian
 * @since: 2022-03-28 17:03
 */
@RestController
@RequestMapping("/settings")
public class SettingController {

    private SettingService settingService;

    private SiteSettingMapper siteSettingMapper;

    @GetMapping("/site")
    public SiteSettingVo getSiteSetting() {
        return siteSettingMapper.toVo(settingService.getSiteSetting());
    }

    @Autowired
    public void setSettingService(SettingService settingService) {
        this.settingService = settingService;
    }

    @Autowired
    public void setSiteSettingMapper(SiteSettingMapper siteSettingMapper) {
        this.siteSettingMapper = siteSettingMapper;
    }
}