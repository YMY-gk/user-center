package com.user.dto.req;

import com.user.dto.base.BaseParam;
import lombok.Data;

@Data
public class UserReq  extends BaseParam {

    private Long userId;

    /**
     * 部门ID
     */
    private Long deptName;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 帐号状态（0正常 1停用，2离职）
     */
    private String status;




}

