package com.user.controller;


import cn.hutool.core.util.StrUtil;
import com.user.common.CommonCode;
import com.user.common.result.Result;
import com.user.util.base.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * <p>
 * 存储用户生成access_token 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@RestController
@RequestMapping("/oauth")
@Slf4j
public class AuthController  {

    //令牌请求的端点
    @Autowired
    private TokenEndpoint tokenEndpoint;
    @Autowired
    private CheckTokenEndpoint checkTokenEndpoint;

    /**
     * 重写token这个默认接口，返回的数据格式统一
     */
    @PostMapping(value = "/token")
    public Result<OAuth2AccessToken> postAccessToken(Principal principal, @RequestParam  Map<String, String> parameters) {
        OAuth2AccessToken accessToken = null;
        try {
            accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        } catch (HttpRequestMethodNotSupportedException e) {
            throw new RuntimeException(e);
        }catch (InvalidGrantException e){
            return ResultUtil.ERROR(CommonCode.LOGIN_ERROR.getCode(),null,e.getMessage());
        }
        return ResultUtil.OK(accessToken);
    }

    /**
     * 重写/oauth/check_token这个默认接口，用于校验令牌，返回的数据格式统一
     */
    @GetMapping(value = "/check_token")
    public Result<Map<String,?>> checkToken(@RequestParam("token") String value)  {
        String token = StrUtil.replaceIgnoreCase(value, "bearer ", Strings.EMPTY);

        Map<String, ?> map = checkTokenEndpoint.checkToken(token);
        return ResultUtil.OK(map);

    }
    /**
     * 重写/oauth/check_token这个默认接口，用于校验令牌，返回的数据格式统一
     */
    @GetMapping(value = "/login_out")
    public Result<Map<String,?>> loginOut(@RequestParam("token") String value)  {
        String token = StrUtil.replaceIgnoreCase(value, "bearer ", Strings.EMPTY);

        Map<String, ?> map = checkTokenEndpoint.checkToken(token);
        return ResultUtil.OK(map);

    }

}