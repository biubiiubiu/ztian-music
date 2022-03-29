package com.example.ztianmusic.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * description: 角色实体类
 * @author: zhangtian
 * @since: 2022-03-23 22:13
 */
@Entity
@Data
public class Role extends BaseEntity {
    private String name;
    private String title;
}
