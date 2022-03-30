package com.example.ztianmusic.entity;

import com.example.ztianmusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * description: 音乐实体类
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:20
 */
@Entity
@Data
public class Music extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    @ManyToMany
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artistList;

    private String description;

    @OneToOne
    private File file;
}
