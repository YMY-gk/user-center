package com.user.dto.resp;

import lombok.Data;

@Data
public class UserVo {

    private Long userId;

    /**
     * 部门ID
     */
    private Long deptName;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户类型（0系统用户 1注册用户）
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 代码
     */
    private String areaCode;
    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 帐号状态（0正常 1停用，2离职）
     */
    private String status;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Long loginDate;

    /**
     * 密码最后更新时间
     */
    private Long pwdUpdateDate;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除：0未，1删除
     */
    private Integer isDel;

    private Integer realmId;

    private String deptId;

}

