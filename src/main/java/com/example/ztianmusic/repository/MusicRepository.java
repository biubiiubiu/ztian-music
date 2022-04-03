package com.example.ztianmusic.repository;

import com.example.ztianmusic.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * description: MusicReposirity
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:17
 */
public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
    @Override
    Optional<Music> findById(String id);
}

