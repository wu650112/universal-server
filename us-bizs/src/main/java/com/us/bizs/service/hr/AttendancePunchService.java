package com.us.bizs.service.hr;

import com.us.bizs.dao.entity.user.hr.HrAttendancePunchRecord;
import com.us.bizs.vo.PunchInVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 考勤打卡服务
 *
 * @author wufan
 * @date 2024/7/9
 */
public interface AttendancePunchService {

    /**
     * 打卡
     *
     * @param punch 打卡信息
     */
    void punchIn(PunchInVO punch);

    /**
     * 获取打卡记录
     *
     * @param dateTime 获取某天的所有打卡记录
     * @param limit 查询多少条 默认1000
     */
    List<HrAttendancePunchRecord> getPunchList(LocalDateTime dateTime,
                                               Integer limit);
}
