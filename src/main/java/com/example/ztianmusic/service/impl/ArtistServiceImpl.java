package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.ArtistCreateRequest;
import com.example.ztianmusic.dto.ArtistDto;
import com.example.ztianmusic.dto.ArtistUpdateRequest;
import com.example.ztianmusic.entity.Artist;
import com.example.ztianmusic.enums.ArtistStatus;
import com.example.ztianmusic.exception.BizException;
import com.example.ztianmusic.exception.ExceptionType;
import com.example.ztianmusic.mapper.ArtistMapper;
import com.example.ztianmusic.repository.ArtistRepository;
import com.example.ztianmusic.service.ArtistService;
import com.example.ztianmusic.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:39
 */
@Service
@Slf4j
public class ArtistServiceImpl extends BaseService implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public ArtistDto create(ArtistCreateRequest artistCreateRequest) {
        Artist artist = mapper.createEntity(artistCreateRequest);
        artist.setStatus(ArtistStatus.DRAFT);
        artist.setCreatedBy(getCurrentUserEntity());
        artist.setUpdatedBy(getCurrentUserEntity());
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest) {
        Optional<Artist> artistOptional = repository.findById(id);
        if (!artistOptional.isPresent()) {
            throw new BizException(ExceptionType.ARTIST_NOT_FOUND);
        }
        Artist artist = mapper.updateEntity(artistOptional.get(), artistUpdateRequest);

        return mapper.toDto(repository.save(artist));
    }

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }
}
