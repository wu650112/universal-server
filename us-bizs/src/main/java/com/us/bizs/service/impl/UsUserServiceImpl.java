package com.us.bizs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.us.base.code.usbasecode.base.dao.UsBaseService;
import com.us.base.code.usbasecode.base.exception.UsBaseException;
import com.us.base.code.usbasecode.config.component.kafka.KafkaSender;
import com.us.base.code.usbasecode.util.UsJwtUtil;
import com.us.bizs.dao.dto.LoginDTO;
import com.us.bizs.dao.entity.UsUser;
import com.us.bizs.dao.mapper.UserMapper;
import com.us.bizs.service.UsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务
 *
 * @author wufan
 * @date 2023/7/21
 */
@Service
@Slf4j
public class UsUserServiceImpl extends UsBaseService<UserMapper, UsUser> implements UsUserService {

    @Autowired
    private UsJwtUtil jwtUtil;

    @Autowired
    private KafkaSender kafkaSender;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String login(LoginDTO loginDTO) {
        QueryWrapper<UsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("login_name", loginDTO.getLoginName())
                .eq("password", loginDTO.getPwd());
        UsUser u = baseMapper.selectOne(queryWrapper);
        if (u == null) {
            throw new UsBaseException("找不到用户！");
        }
        log.info("阿达");
        return jwtUtil.generateToken(u.getLoginName(), u.getName());
    }

    @Override
    public String test() {
        log.error("链路追踪哦");
        kafkaSender.send("faker","你好啊kafka");
        this.test3();
        return null;
    }

    private void test3() {
        log.info("试试看");
    }
}
