package com.example.ztianmusic.entity;

import com.example.ztianmusic.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * description: 用户实体类
 *
 * @author: zhangtian
 * @since: 2022-03-23 20:56
 */
@Entity
@Data
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;

    private String nickname;

    // todo 这里考虑要不要用FetchType.LAZY
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean locked = false;

    private Boolean enabled = true;

    private String lastLoginIp;

    private Date lastLoginTime;
}
