package com.example.ztianmusic.repository;

import com.example.ztianmusic.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:51
 */
public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}

