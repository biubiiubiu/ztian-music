CREATE TABLE playlist
(
    `id`                 VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '歌单ID',
    `name`               VARCHAR(64) NOT NULL COMMENT '歌单名字',
    `description`        TEXT        NULL COMMENT '歌单简介',
    `cover_id`           VARCHAR(32) NULL COMMENT '歌单封面ID',
    `status`             VARCHAR(32)          DEFAULT 'DRAFT' NOT NULL COMMENT '歌单上架状态，DRAFT-草稿，PUBLISHED-已上架，CLOSED-已下架',
    `created_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '创建者用户ID',
    `updated_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '更新者用户ID',
    `recommended`        TINYINT              DEFAULT 0 NOT NULL COMMENT '是否推荐：推荐：1； 不推荐：0；默认：0',
    `special`            TINYINT     NOT NULL DEFAULT 0 COMMENT '是否特色歌单：特色歌单：1； 否则：0；默认：0',
    `recommend_factor`   INT                  DEFAULT 0 NOT NULL COMMENT '推荐因数：越高越在上面',
    `created_time`       datetime(6) NOT NULL COMMENT '创建时间',
    `updated_time`       datetime(6) NOT NULL COMMENT '更新时间',
    CONSTRAINT `c_cover_id`
        FOREIGN KEY (cover_id) REFERENCES `file` (id),
    CONSTRAINT `playlist_created_by_user_id`
        FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `playlist_updated_by_user_id`
        FOREIGN KEY (`updated_by_user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '歌单表';