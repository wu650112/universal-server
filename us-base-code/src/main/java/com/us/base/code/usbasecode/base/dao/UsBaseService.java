package com.us.base.code.usbasecode.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 基础服务
 *
 * @author admin
 * @date 2023/7/21
 */
public abstract class UsBaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
