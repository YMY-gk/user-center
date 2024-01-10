package com.user.config.bean;

import com.user.domain.SysUser;
import com.user.dto.resp.LoginUserInfo;
import lombok.Data;

import java.util.List;

public class LoginSession {
    private static ThreadLocal<TokenInfo> sessions = new ThreadLocal();


    public LoginSession(){

    }

    public static TokenInfo get( ){
        if(null==sessions.get()){
            TokenInfo sessionInfo=new TokenInfo();
            sessions.set(sessionInfo);
        }
        return sessions.get();
    }
    public static void set(TokenInfo info ){
            sessions.set(info);
    }
    public static void remove() {
        sessions.remove();
    }
    public static String getRealm() {
        return get().getRealm();
    }

    public static Long getUserId() {
        return  get().getUserId();
    }

    public static String getUserName() {
        return get().getUserName();
    }

    public static String getClientId() {
        return  get().getClientId();
    }

    public static List<String> getAuthorities() {
        return  get().getAuthorities();
    }

    public static List<String> getScope() {
        return  get().getScope();
    }

    public static Long getExp() {
        return  get().getExp();
    }

    public static String getJti() {
        return  get().getJti();
    }

    public static LoginUserInfo getUser() {
        return  get().getUser();
    }

}
