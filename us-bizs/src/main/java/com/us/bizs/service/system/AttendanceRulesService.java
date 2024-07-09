package com.us.bizs.service.system;

import com.us.bizs.dao.entity.user.hr.HrAttendancePunchAbnormalRecord;
import com.us.bizs.dao.entity.user.hr.HrAttendancePunchRecord;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 考勤打卡规则
 *
 * @author wufan
 * @date 2024/7/8
 */
@Service
public class AttendanceRulesService {

    @Autowired
    private KieContainer kieContainer;

    /**
     * 打卡异常规则
     *
     * @see /src/main/resources/META-INF/rules/attendance-rules.drl
     */
    public void processAttendance(HrAttendancePunchRecord attendanceRecord) {
        KieSession kieSession = kieContainer.newKieSession("attendanceKSession");
        kieSession.insert(attendanceRecord);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    /**
     * 生成打卡异常
     *
     * @see /src/main/resources/META-INF/rules/attendance-rules.drl
     */
    public void processAttendanceAbnormal(HrAttendancePunchAbnormalRecord attendanceRecord) {
        KieSession kieSession = kieContainer.newKieSession("attendanceKSession");
        kieSession.insert(attendanceRecord);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
