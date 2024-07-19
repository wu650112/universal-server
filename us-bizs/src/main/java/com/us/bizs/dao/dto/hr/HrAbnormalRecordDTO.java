package com.us.bizs.dao.dto.hr;

import com.us.bizs.dao.entity.user.hr.HrAttendancePunchRecord;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 考勤异常信息生成
 *
 * @author wufan
 * @date 2024/7/10
 */
@Data
@Accessors(chain = true)
public class HrAbnormalRecordDTO {

    private Integer userCode;

    /**
     * 当天打卡信息
     */
    private List<HrAttendancePunchRecord> punchRecordList;

    /**
     * 当天请假记录
     */
    private List<String> leaveRecords;

    /**
     * 异常类型：1-迟到  2-早退  3-旷工 4-缺勤
     * 缺勤是指员工在规定的工作时间内未按时到岗或者提前离岗，
     * 但是有合理理由或者经过请假同意的情况；
     * 而旷工是指员工在规定的工作时间内未按时到岗或者提前离岗，且没有合理理由或者未经请假同意的情况
     */
    private Integer abnormalType;
}
