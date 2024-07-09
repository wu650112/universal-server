package com.us.bizs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.us.base.code.usbasecode.base.dao.UsBaseService;
import com.us.base.code.usbasecode.base.dao.UsEntityUtils;
import com.us.base.code.usbasecode.filter.token.UserContext;
import com.us.base.code.usbasecode.util.BaseUserInfo;
import com.us.bizs.dao.entity.UsUser;
import com.us.bizs.dao.entity.user.hr.HrAttendancePunchAbnormalRecord;
import com.us.bizs.dao.entity.user.hr.HrAttendancePunchRecord;
import com.us.bizs.dao.mapper.user.hr.HrAttendancePunchMapper;
import com.us.bizs.service.AttendancePunchService;
import com.us.bizs.service.system.AttendanceRulesService;
import com.us.bizs.vo.PunchInVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 考勤打卡服务
 *
 * @author wufan
 * @date 2024/7/9
 */
@Service
@Slf4j
public class AttendancePunchServiceImpl extends UsBaseService<HrAttendancePunchMapper, HrAttendancePunchRecord>
        implements AttendancePunchService {

    @Autowired
    private AttendanceRulesService rulesService;

    @Override
    public void punchIn(PunchInVO punch) {
        BaseUserInfo user = UserContext.getUser();
        HrAttendancePunchRecord record = new HrAttendancePunchRecord();
        record.setActualPunchAddress(punch.getAddress());
        record.setEmpCode(user.getUserId());
        record.setEmpName(user.getUserName());
        UsEntityUtils.setChange(record);
        UsEntityUtils.setCreate(record);
        record.setAttendancePunchTime(LocalDateTime.now());
        record.setPunchType(punch.getPunchType());
        // 校验
        rulesService.processAttendance(record);
        super.baseMapper.insert(record);
    }

    @Override
    public List<HrAttendancePunchRecord> getPunchList(LocalDateTime dateTime,Integer limit) {
        QueryWrapper<HrAttendancePunchRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attendance_punch_time", dateTime);
        return super.baseMapper.selectList(queryWrapper);
    }
}
