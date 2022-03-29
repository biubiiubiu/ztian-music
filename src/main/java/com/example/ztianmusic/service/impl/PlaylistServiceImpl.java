package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.PlaylistDto;
import com.example.ztianmusic.entity.Playlist;
import com.example.ztianmusic.exception.BizException;
import com.example.ztianmusic.exception.ExceptionType;
import com.example.ztianmusic.mapper.PlaylistMapper;
import com.example.ztianmusic.repository.PlaylistRepository;
import com.example.ztianmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:52
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public PlaylistDto get(String id) {
        Optional<Playlist> playlist = repository.findById(id);
        if (!playlist.isPresent()) {
            throw new BizException(ExceptionType.PLAYLIST_NOT_FOUND);
        }
        return mapper.toDto(playlist.get());
    }

    @Autowired
    public void setRepository(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(PlaylistMapper mapper) {
        this.mapper = mapper;
    }
}
