package com.us.base.code.usbasecode.base.dao;

import lombok.Data;

/**
 * 基础响应
 * 区分UsBaseRespResult
 *
 * @author wufan
 * @date 2023/8/30
 */
@Data
public class UsBaseResponse {

    private int status;

    private String message;

    private Boolean success;
}
