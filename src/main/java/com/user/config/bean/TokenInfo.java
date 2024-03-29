package com.user.config.bean;

import com.user.domain.SysUser;
import com.user.dto.resp.LoginUserInfo;
import lombok.Data;

import java.util.List;

@Data
public class TokenInfo {
    private Long realmId;
    private Long userId;
    private String userName;
    private String clientId;
    private List<String> authorities;
    private List<String> scope;
    private Long exp;
    private String jti;
    private LoginUserInfo user;
}
