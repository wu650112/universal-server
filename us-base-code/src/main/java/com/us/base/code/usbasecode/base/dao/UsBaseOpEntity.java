package com.us.base.code.usbasecode.base.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 更新对象
 *
 * @author wufan
 * @date 2023/7/21
 */
@Data
public class UsBaseOpEntity extends UsBaseEntity {

    /**
     * 更新人
     */
    @TableField(value = "change_code")
    private Integer changeCode;

    /**
     * 更新人姓名
     */
    @TableField(value = "change_name")
    private String changeName;

    /**
     * 更新时间
     */
    @TableField(value = "change_time")
    private LocalDateTime changeTime;
}
