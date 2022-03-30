package com.example.ztianmusic.repository;

import com.example.ztianmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-23 21:24
 */
public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    @Override
    User getById(String id);

    @Override
    Page<User> findAll(Pageable pageable);

    User getByOpenId(String openId);
}
