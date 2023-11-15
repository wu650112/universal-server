package com.us.base.code.usbasecode.base.exception;

import com.us.base.code.usbasecode.base.enums.BaseExceptionEnum;

/**
 * 基础异常
 *
 * @author wufan
 * @date 2023/7/21
 */
public class UsBaseException extends RuntimeException {

    private final Boolean success;

    private Integer code;

    private String message;

    public UsBaseException(BaseExceptionEnum baseExceptionEnum) {
        this.success = baseExceptionEnum.getIsSuccess();
        this.code = baseExceptionEnum.getResponseCode();
        this.message = baseExceptionEnum.getResponseMsg();
    }

    public UsBaseException(String msg) {
        this.success = true;
        this.code = 0;
        this.message = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
