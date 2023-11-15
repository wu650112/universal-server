package com.us.base.code.usbasecode.base.dao;

import lombok.Data;

/**
 * 基础查询
 *
 * @author wufan
 * @date 2023/7/21
 */
@Data
public class UsBaseQuery extends UsBaseEntity {

    private int pageNum;

    private int pageSize;
}
