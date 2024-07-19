package com.us.bizs.dao.entity.user.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.us.base.code.usbasecode.base.dao.UsBaseOpEntity;
import lombok.Data;

import java.time.LocalTime;

/**
 * 考勤计划实体类
 *
 * @author admin
 */
@TableName(value = "hr_attendance_plan", autoResultMap = true)
@Data
public class HrAttendancePlan extends UsBaseOpEntity {

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 考勤计划名称
     */
    @TableField("plan_name")
    private String planName;

    /**
     * 每周出勤天数
     */
    @TableField("weekly_work_days")
    private Integer weeklyWorkDays;

    /**
     * 上班打卡时间
     */
    @TableField("clock_in_time")
    private LocalTime clockInTime;

    /**
     * 下班打卡时间
     */
    @TableField("clock_out_time")
    private LocalTime clockOutTime;

    /**
     * 状态：1-有效，2-无效
     */
    @TableField("status")
    private Integer status;

}
