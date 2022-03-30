package com.example.ztianmusic.repository;

import com.example.ztianmusic.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:38
 */
public interface ArtistRepository extends JpaRepository<Artist, String> {
    @Override
    Optional<Artist> findById(String id);
}

