package com.user.config.Handler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * token 自定义token数据
 */
@Slf4j
@Data
public class UserInfo<R> extends User {
    private R r;
    public UserInfo(String username,
                       String password,
                       Collection<? extends GrantedAuthority> authorities,
                       R r) {
        super(username, password, authorities);
        this.r=r;
    }
}