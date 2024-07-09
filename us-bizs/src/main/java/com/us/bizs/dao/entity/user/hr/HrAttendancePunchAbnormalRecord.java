package com.us.bizs.dao.entity.user.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.us.base.code.usbasecode.base.dao.UsBaseOpEntity;
import lombok.Data;

import java.time.LocalDate;


/**
 * @author admin
 */
@TableName(value = "hr_attendance_punch_abnormal_record", autoResultMap = true)
@Data
public class HrAttendancePunchAbnormalRecord extends UsBaseOpEntity {

    @TableId
    private Integer id;

    @TableField("user_code")
    private Integer userCode;

    @TableField("user_name")
    private String userName;

    @TableField("abnormal_type")
    private Byte abnormalType;

    @TableField("abnormal_date")
    private LocalDate abnormalDate;

}
