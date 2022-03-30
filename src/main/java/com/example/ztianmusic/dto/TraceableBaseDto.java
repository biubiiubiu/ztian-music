package com.example.ztianmusic.dto;

import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 20:12
 */
@Data
public class TraceableBaseDto extends BaseDto {
    private UserDto createdBy;

    private UserDto updatedBy;
}

