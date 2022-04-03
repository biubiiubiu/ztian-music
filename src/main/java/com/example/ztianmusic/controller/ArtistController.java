package com.example.ztianmusic.controller;

import com.example.ztianmusic.dto.ArtistCreateRequest;
import com.example.ztianmusic.dto.ArtistSearchFilter;
import com.example.ztianmusic.dto.ArtistUpdateRequest;
import com.example.ztianmusic.dto.RecommendRequest;
import com.example.ztianmusic.mapper.ArtistMapper;
import com.example.ztianmusic.service.ArtistService;
import com.example.ztianmusic.vo.ArtistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * description: 音乐人crud
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:34
 */
@RestController
@RequestMapping("/artists")
public class ArtistController {

    ArtistService artistService;

    ArtistMapper artistMapper;

    @PostMapping
    public ArtistVo create(@Validated @RequestBody ArtistCreateRequest artistCreateRequest) {
        return artistMapper.toVo(artistService.create(artistMapper.toDto(artistCreateRequest)));
    }

    @PostMapping("/{id}")
    public ArtistVo update(@PathVariable String id, @Validated @RequestBody ArtistUpdateRequest artistUpdateRequest) {
        return artistMapper.toVo(artistService.update(id, artistMapper.toDto(artistUpdateRequest)));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<ArtistVo> search(@Validated ArtistSearchFilter artistSearchFilter) {
        return artistService.search(artistSearchFilter).map(artistMapper::toVo);
    }

    @PostMapping("/{id}/recommend")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ArtistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return artistMapper.toVo(artistService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @PostMapping("/{id}/cancel_recommendation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ArtistVo cancelRecommendation(@PathVariable String id) {
        return artistMapper.toVo(artistService.cancelRecommendation(id));
    }

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setArtistMapper(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }
}