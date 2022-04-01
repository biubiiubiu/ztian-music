package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.PlaylistDto;
import com.example.ztianmusic.dto.PlaylistSearchFilter;
import com.example.ztianmusic.entity.Playlist;
import org.springframework.data.domain.Page;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:51
 */
public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}

