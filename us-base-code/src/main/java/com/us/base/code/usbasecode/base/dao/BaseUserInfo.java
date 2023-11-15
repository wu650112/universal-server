package com.us.base.code.usbasecode.base.dao;

import lombok.Data;

/**
 * 基础用户信息
 *
 * @author wufan
 * @date 2023/8/31
 */
@Data
public class BaseUserInfo {

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String name;

}
