package com.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;

    /**
     * 登录账号
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 用户昵称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户类型（00系统用户 01注册用户）
     */
    @TableField("user_type")
    private String userType;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @TableField("phonenumber")
    private String phonenumber;
    /**
     * 国际代码
     */
    @TableField("area_code")
    private String areaCode;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @TableField("sex")
    private String sex;

    /**
     * 头像路径
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 盐加密
     */
    @TableField("salt")
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 最后登录IP
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @TableField("login_date")
    private Long loginDate;

    /**
     * 密码最后更新时间
     */
    @TableField(value = "pwd_update_date",fill = FieldFill.INSERT)
    private Long pwdUpdateDate;

    /**
     * 创建者
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value ="create_time",fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Long updateTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否删除：0未，1删除
     */
    @TableField("is_del")
    @TableLogic
    private Integer isDel;
    /**
     * 部门
     */
    @TableField(exist = false)
    private List<Long> deptIds;
    /**
     * 角色
     */
    @TableField(exist = false)
    private List<Long> roleIds;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
