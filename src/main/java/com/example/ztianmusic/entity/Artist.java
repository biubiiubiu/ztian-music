package com.example.ztianmusic.entity;

import com.example.ztianmusic.enums.ArtistStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * description: 音乐人实体类
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:26
 */
@Entity
@Data
public class Artist extends TraceableBaseEntity {

    private String name;

    private String remark;

    @OneToOne
    private File photo;

    @ManyToMany
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    private ArtistStatus status;
}
