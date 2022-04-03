package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.ArtistCreateRequest;
import com.example.ztianmusic.dto.ArtistDto;
import com.example.ztianmusic.dto.ArtistSearchFilter;
import com.example.ztianmusic.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:38
 */
public interface ArtistService extends GeneralService<Artist, ArtistDto> {
    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    List<ArtistDto> list();

    Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);

    ArtistDto recommend(String id, Integer recommendFactor);

    ArtistDto cancelRecommendation(String id);
}


