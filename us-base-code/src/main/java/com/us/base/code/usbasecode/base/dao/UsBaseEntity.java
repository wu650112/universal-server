package com.us.base.code.usbasecode.base.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 新建对象表
 *
 * @author wufan
 * @date 2023/7/21
 */
@Data
public class UsBaseEntity {

    /**
     * 创建人编号
     */
    @TableField(value = "create_code")
    private Integer createCode;

    /**
     * 创建人姓名
     */
    @TableField(value = "create_name")
    private String createName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

}
