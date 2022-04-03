package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.PlaylistDto;
import com.example.ztianmusic.dto.PlaylistSearchFilter;
import com.example.ztianmusic.entity.Playlist;
import com.example.ztianmusic.exception.BizException;
import com.example.ztianmusic.exception.ExceptionType;
import com.example.ztianmusic.mapper.MapperInterface;
import com.example.ztianmusic.mapper.PlaylistMapper;
import com.example.ztianmusic.repository.PlaylistRepository;
import com.example.ztianmusic.repository.specs.PlaylistSpecification;
import com.example.ztianmusic.repository.specs.SearchCriteria;
import com.example.ztianmusic.repository.specs.SearchOperation;
import com.example.ztianmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:52
 */
@Service
public class PlaylistServiceImpl extends TraceableGeneralServiceImpl<Playlist, PlaylistDto> implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter) {
        PlaylistSpecification specs = new PlaylistSpecification();
        specs.add(new SearchCriteria("name", playlistSearchFilter.getName(), SearchOperation.MATCH));
        if (playlistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", playlistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, playlistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public PlaylistDto recommend(String id, Integer recommendFactor) {
        Playlist playlist = getEntity(id);
        playlist.setRecommended(true);
        playlist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto cancelRecommendation(String id) {
        Playlist playlist = getEntity(id);
        playlist.setRecommended(false);
        playlist.setRecommendFactor(0);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto makeSpecial(String id) {
        Playlist playlist = getEntity(id);
        playlist.setSpecial(true);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto cancelSpecial(String id) {
        Playlist playlist = getEntity(id);
        playlist.setSpecial(false);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public JpaRepository<Playlist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Playlist, PlaylistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.PLAYLIST_NOT_FOUND;
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
