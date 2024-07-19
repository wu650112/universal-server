package com.us.bizs.controller;

import com.us.base.code.usbasecode.base.dao.UsBaseRespResult;
import com.us.bizs.service.hr.AttendancePunchService;
import com.us.bizs.vo.PunchInVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打卡系统
 *
 * @author wufan
 * @date 2024/7/9
 */
@RestController
@RequestMapping("/hr/attendance")
@Slf4j
public class AttendancePunchController {

    @Autowired
    private AttendancePunchService attendancePunchService;

    @PostMapping("/punchIn")
    public UsBaseRespResult<Void> punchIn(@RequestBody PunchInVO punch) {
        attendancePunchService.punchIn(punch);
        return UsBaseRespResult.ok();
    }
}
