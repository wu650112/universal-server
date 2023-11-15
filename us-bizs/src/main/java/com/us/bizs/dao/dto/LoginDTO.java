package com.us.bizs.dao.dto;

import lombok.Data;

/**
 * 登录
 *
 * @author wufan
 * @date 2023/7/21
 */
@Data
public class LoginDTO {

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 账号密码
     */
    private String pwd;

}
