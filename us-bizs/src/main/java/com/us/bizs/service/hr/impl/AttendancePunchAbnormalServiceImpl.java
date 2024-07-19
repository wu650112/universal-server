package com.us.bizs.service.hr.impl;

import com.us.base.code.usbasecode.base.dao.UsBaseService;
import com.us.bizs.dao.entity.user.hr.HrAttendancePunchAbnormalRecord;
import com.us.bizs.dao.mapper.user.hr.HrAttendancePunchAbnormalRecordMapper;
import com.us.bizs.service.hr.AttendancePunchAbnormalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 考勤打卡服务
 *
 * @author wufan
 * @date 2024/7/9
 */
@Service
@Slf4j
public class AttendancePunchAbnormalServiceImpl extends UsBaseService<HrAttendancePunchAbnormalRecordMapper, HrAttendancePunchAbnormalRecord>
        implements AttendancePunchAbnormalService {

}
