package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.MusicCreateRequest;
import com.example.ztianmusic.dto.MusicDto;
import com.example.ztianmusic.dto.MusicUpdateRequest;

import java.util.List;

/**
 * description: music service
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:15
 */
public interface MusicService {
    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);

    void close(String id);
}