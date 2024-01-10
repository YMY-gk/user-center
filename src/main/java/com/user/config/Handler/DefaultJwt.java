package com.user.config.Handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.user.util.BeanMapTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
        //把用户名设置到JWT中
        UserInfo user = (UserInfo) authentication.getPrincipal();
        if (ObjectUtil.isNotEmpty(user.getR())) {
            Map<String, Object> map = BeanMapTool.beanToMap(user.getR());
           ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
        }
        Date date = DateUtils.addDays(new Date(),1);
        ((DefaultOAuth2AccessToken) accessToken).setExpiration(date);
        return super.enhance(accessToken, authentication);
    }
}