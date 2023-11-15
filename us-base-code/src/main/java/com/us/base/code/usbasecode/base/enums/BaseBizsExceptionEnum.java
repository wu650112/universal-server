package com.us.base.code.usbasecode.base.enums;

/**
 * 业务异常
 *
 * @author wufan
 * @date 2023/7/21
 */
public enum BaseBizsExceptionEnum implements BaseExceptionEnum {

    /**
     * token校验
     */
    TOKEN_NOT_FIND(false, -1, "找不到token"),
    TOKEN_INVALID(false, -1, "无效token"),

    /**
     * 幂等校验
     */
    IDEMPOTENCE_INVALID(false, -1, "请勿重复提交"),

    /**
     * 系统异常
     */
    WAITING_UNLOCK(false, -1, "请等待系统完成结算"),
    ;

    private Boolean success;

    private Integer code;

    private String msg;

    BaseBizsExceptionEnum(Boolean isSuccess, Integer responseCode, String responseMsg) {
        this.success = isSuccess;
        this.code = responseCode;
        this.msg = responseMsg;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.success = isSuccess;
    }

    @Override
    public Boolean getIsSuccess() {
        return this.success;
    }

    @Override
    public Integer getResponseCode() {
        return this.code;
    }

    public void setResponseCode(Integer responseCode) {
        this.code = responseCode;
    }

    @Override
    public String getResponseMsg() {
        return this.msg;
    }

    public void setResponseMsg(String responseMsg) {
        this.msg = responseMsg;
    }
}
