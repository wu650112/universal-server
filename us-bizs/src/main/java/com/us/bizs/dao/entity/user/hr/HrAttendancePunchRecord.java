package com.us.bizs.dao.entity.user.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.us.base.code.usbasecode.base.dao.UsBaseOpEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author admin
 */
@Data
@TableName("hr_attendance_punch_record")
@Accessors(chain = true)
public class HrAttendancePunchRecord extends UsBaseOpEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 人员编码
     */
    @TableField("emp_code")
    private Integer empCode;

    /**
     * 人员名称
     */
    @TableField("emp_name")
    private String empName;

    /**
     * 打卡类型：1-上班卡；2下班卡
     */
    @TableField("punch_type")
    private Integer punchType;

    /**
     * 打卡日期
     */
    @TableField("punch_date")
    private LocalDate punchDate;

    /**
     * 考勤打卡时间
     */
    @TableField("attendance_punch_time")
    private LocalDateTime attendancePunchTime;

    /**
     * 考勤地点类型 office-办公点 store-门店 other-其他
     */
    @TableField("attendance_place_type")
    private String attendancePlaceType;

    /**
     * 考勤地点编码
     */
    @TableField("attendance_place_code")
    private String attendancePlaceCode;

    /**
     * 考勤地点名称
     */
    @TableField("attendance_place_name")
    private String attendancePlaceName;

    /**
     * 实际打卡时间
     */
    @TableField("actual_punch_time")
    private LocalDateTime actualPunchTime;

    /**
     * 实际打卡经度
     */
    @TableField("actual_punch_longitude")
    private BigDecimal actualPunchLongitude;

    /**
     * 实际打卡纬度
     */
    @TableField("actual_punch_latitude")
    private BigDecimal actualPunchLatitude;

    /**
     * 实际打卡地区
     */
    @TableField("actual_punch_region")
    private String actualPunchRegion;

    /**
     * 实际打卡地址
     */
    @TableField("actual_punch_address")
    private String actualPunchAddress;

    /**
     * 打卡地址和考勤地址的距离
     */
    private Integer distance;

    /**
     * 0-有效；1-无效
     */
    @TableField("valid_status")
    private Integer validStatus;

    /**
     * 最大上班打卡时间
     */
    @TableField("max_start_punch_time")
    private LocalDateTime maxStartPunchTime;

    /**
     * 最小下班打卡时间
     */
    @TableField("min_end_punch_time")
    private LocalDateTime minEndPunchTime;

    /**
     * 是否是跨天班次打卡,0-否，1-是
     */
    @TableField("is_cross_punch")
    private Integer isCrossPunch;

    /**
     * 班次主键
     */
    @TableField("classes_id")
    private Integer classesId;

    /**
     * 设备id
     */
    @TableField("equipment_id")
    private String equipmentId;

    /**
     * 班次id来源 1.考勤组自带班次  2.全勤自定义班次 3.半勤自定义班次 4-排班基础班次 5-排班自定义班次
     */
    @TableField("classes_source")
    private Integer classesSource;

}
