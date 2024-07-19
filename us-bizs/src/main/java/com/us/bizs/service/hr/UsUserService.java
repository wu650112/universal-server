package com.us.bizs.service.hr;

import com.baomidou.mybatisplus.extension.service.IService;
import com.us.bizs.dao.dto.LoginDTO;
import com.us.bizs.dao.entity.UsUser;

/**
 * 用户服务
 *
 * @author wufan
 * @date 2023/7/21
 */
public interface UsUserService extends IService<UsUser> {

    /**
     * 用户登录
     *
     * @param loginDTO 登录参数
     * @return token
     * @author wufan
     * @date 2023/7/21
     */
    String login(LoginDTO loginDTO);


    String test();
}
