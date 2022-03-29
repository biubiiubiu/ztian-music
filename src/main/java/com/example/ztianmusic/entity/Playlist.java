package com.example.ztianmusic.entity;

import com.example.ztianmusic.enums.PlayListStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * description: playlist实体类
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:45
 */
@Entity
@Data
public class Playlist extends AbstractEntity {
    private String name;

    private String description;

    @OneToOne
    private File cover;

    @Enumerated(EnumType.STRING)
    private PlayListStatus status;

    @OneToOne
    private User creator;

    @ManyToMany
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;
}