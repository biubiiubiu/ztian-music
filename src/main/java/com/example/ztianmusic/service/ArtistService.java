package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.ArtistCreateRequest;
import com.example.ztianmusic.dto.ArtistDto;
import com.example.ztianmusic.dto.ArtistUpdateRequest;

import java.util.List;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:38
 */
public interface ArtistService {
    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest);

    List<ArtistDto> list();
}
