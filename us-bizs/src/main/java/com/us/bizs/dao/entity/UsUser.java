package com.us.bizs.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.us.base.code.usbasecode.base.dao.UsBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 系统用户
 *
 * @author admin
 * @date 2023/7/21
 */
@TableName("us_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsUser extends UsBaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 邮件
     */
    @TableField("email")
    private String email;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 登录名
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 是否可用 1- 可用 0-停用
     */
    @TableField("enabled")
    private Integer enabled;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("op_time")
    private Date opTime;
}
