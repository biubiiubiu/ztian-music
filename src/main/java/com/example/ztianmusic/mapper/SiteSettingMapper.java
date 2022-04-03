package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.SiteSettingDto;
import com.example.ztianmusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 17:01
 */
@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}