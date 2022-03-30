ALTER TABLE `user`
    ADD COLUMN `open_id` VARCHAR(32) NOT NULL COMMENT '用户的身份认证' AFTER `enabled`;