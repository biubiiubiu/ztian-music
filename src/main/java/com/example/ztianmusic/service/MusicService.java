package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.MusicCreateRequest;
import com.example.ztianmusic.dto.MusicDto;
import com.example.ztianmusic.dto.MusicSearchFilter;
import com.example.ztianmusic.dto.MusicUpdateRequest;
import com.example.ztianmusic.entity.Music;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * description: music service
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:15
 */
public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}