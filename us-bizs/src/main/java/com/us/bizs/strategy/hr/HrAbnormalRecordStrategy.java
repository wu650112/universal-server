package com.us.bizs.strategy.hr;

import com.us.bizs.dao.entity.user.hr.HrAttendancePunchAbnormalRecord;
import com.us.bizs.service.impl.AttendancePunchAbnormalServiceImpl;
import com.us.bizs.strategy.BaseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 异常处理策略
 *
 * @author wufan
 * @date 2024/7/9
 */
@Service
public class HrAbnormalRecordStrategy implements BaseStrategy<List<HrAttendancePunchAbnormalRecord>> {

    @Autowired
    private AttendancePunchAbnormalServiceImpl abnormalService;

    private String strategyType;

    public String getStrategyType() {
        return strategyType;
    }

    protected void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    @Override
    public void execute(List<HrAttendancePunchAbnormalRecord> data) {
        abnormalService.saveBatch(data);
    }
}
