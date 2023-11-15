package com.us.base.code.usbasecode.base.dao;

import com.github.pagehelper.StringUtil;

import java.io.Serializable;

/**
 * 基础响应
 *
 * @author admin
 */
public class UsBaseRespResult<T> implements Serializable {

    private static final long serialVersionUID = -2L;

    private T data;

    private Integer code;

    private String msg;

    private Boolean success;

    public UsBaseRespResult() {
        super();
    }

    public UsBaseRespResult(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> UsBaseRespResult<T> success(T data) {
        return new UsBaseRespResult<T>(true, 0, "请求成功", data);
    }

    public static <T> UsBaseRespResult<T> fail(String msg) {
        if (StringUtil.isEmpty(msg)) {
            msg = "请求失败";
        }
        return new UsBaseRespResult<T>(false, -1, msg, null);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
