package com.us.base.code.usbasecode.util;

import lombok.Getter;

/**
 * 基础用户信息
 *
 * @author wufan
 * @date 2023/8/31
 */
@Getter
public class BaseUserInfo {

    /**
     * 登录名
     */
    private String loginName;


    /**
     * 姓名
     */
    private String userName;

    /**
     * 用户id
     */
    private Integer userId;


    protected void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    protected void setUserName(String userName) {
        this.userName = userName;
    }

    protected void setUserId(Integer userId) {
        this.userId = userId;
    }
}
