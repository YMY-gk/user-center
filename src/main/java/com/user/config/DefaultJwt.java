package com.user.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * token 自定义token数据
 */
@Slf4j
public class DefaultJwt extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        log.info(authentication.getPrincipal().toString());
        log.info( SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //把用户名设置到JWT中
        Map<String, Object> additionalInformation = new LinkedHashMap<>();
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("author", "江南一点雨");
        info.put("email", "wangsong0210@gmail.com");
        info.put("site", "www.javaboy.org");
        info.put("weixin", "a_java_boy2");
        info.put("WeChat Official Accounts", "江南一点雨");
        info.put("GitHub", "https://github.com/lenve");
        info.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        additionalInformation.put("info", info);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
        Date date = DateUtils.addDays(new Date(),1);
        ((DefaultOAuth2AccessToken) accessToken).setExpiration(date);

        return super.enhance(accessToken, authentication);
    }
}