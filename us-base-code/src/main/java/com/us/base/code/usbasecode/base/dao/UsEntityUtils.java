package com.us.base.code.usbasecode.base.dao;

import com.us.base.code.usbasecode.filter.token.UserContext;

import java.time.LocalDateTime;

/**
 * 实体对象
 *
 * @author wufan
 * @date 2024/7/9
 */
public class UsEntityUtils {

    public static <T extends UsBaseEntity> void setCreate(T entity) {
        entity.setCreateCode(UserContext.getUserId());
        entity.setCreateName(UserContext.getUserName());
        entity.setCreateTime(LocalDateTime.now());
    }

    public static <T extends UsBaseOpEntity> void setChange(T entity) {
        entity.setChangeCode(UserContext.getUserId());
        entity.setChangeName(UserContext.getUserName());
        entity.setChangeTime(LocalDateTime.now());
    }
}
