package com.example.ztianmusic.repository;

import com.example.ztianmusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:35
 */
public interface FileRepository extends JpaRepository<File, String> {
}
