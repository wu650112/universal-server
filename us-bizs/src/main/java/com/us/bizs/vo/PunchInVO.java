package com.us.bizs.vo;

import lombok.Data;

/**
 * 打卡
 *
 * @author wufan
 * @date 2024/7/9
 */
@Data
public class PunchInVO {

    /**
     * 打卡地点
     */
    private String address;


    /**
     * 打卡类型 1-上班卡  2-下班卡
     */
    private Integer punchType;
}
