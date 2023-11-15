package com.us.base.code.usbasecode.base.enums;

/**
 * @author wufan
 * @date 2023/7/21
 */
public interface BaseExceptionEnum {

    Boolean getIsSuccess();

    Integer getResponseCode();

    String getResponseMsg();
}
