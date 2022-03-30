package com.example.ztianmusic.controller;

import com.example.ztianmusic.dto.MusicCreateRequest;
import com.example.ztianmusic.dto.MusicUpdateRequest;
import com.example.ztianmusic.mapper.MusicMapper;
import com.example.ztianmusic.service.MusicService;
import com.example.ztianmusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 音乐业务类
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:22
 */

@RestController
@RequestMapping("/musics")
public class MusicController {

    private MusicService musicService;

    private MusicMapper musicMapper;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
        return musicMapper.toVo(musicService.create(musicMapper.toDto(musicCreateRequest)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
        return musicMapper.toVo(musicService.update(id, musicMapper.toDto(musicUpdateRequest)));
    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<MusicVo> list() {
//        return musicService.list().stream().map(musicMapper::toVo).collect(Collectors.toList());
        return null;
    }

    @PostMapping("/{id}/publish")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void publish(@PathVariable String id) {
        musicService.publish(id);
    }

    @PostMapping("/{id}/close")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void close(@PathVariable String id) {
        musicService.close(id);
    }

    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @Autowired
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
}