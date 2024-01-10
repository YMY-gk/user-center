package com.user.config.Handler;

import cn.hutool.json.JSONUtil;
import com.user.config.bean.LoginSession;
import com.user.config.bean.TokenInfo;
import com.user.domain.SysUser;
import com.user.dto.resp.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class UserLoginFilter implements Filter {

    String key = "srs:userInfo:";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime=System.currentTimeMillis();
        log.info("接口请求开始");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {
            String tokenInfo = request.getHeader("tokenInfo");

            if (StringUtils.isEmpty(tokenInfo)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
            LoginUserInfo userInfo = JSONUtil.toBean(tokenInfo, LoginUserInfo.class);
            TokenInfo info = JSONUtil.toBean(tokenInfo, TokenInfo.class);
            info.setUser(userInfo);
            LoginSession.set(info);

            //    log.info("用户信息:{}",userInfo);
//            String cacheKey = key+ userInfo.getUsername();
//            Optional<String> optional = JedisTool.get(cacheKey);
//            if (optional.isPresent()) {
//                LoginSession.putUser(JSONObject.parseObject(optional.get(), cn.comein.common.srs.dto.UserInfo.class));
//                if (null != LoginSession.getUser().getRoleId() && null != LoginSession.getUser().getAccountType()) {
//                    dataAuth(request.getRequestURI());
//                    filterChain.doFilter(servletRequest, servletResponse);
//                    log.info("接口:{},耗时：{}ms", request.getRequestURI(), System.currentTimeMillis() - startTime);
//                    return;
//                }
//            }
//
//            cn.comein.common.srs.dto.UserInfo userInfo1 = new cn.comein.common.srs.dto.UserInfo();
//            BeanUtils.copyProperties(userInfo, userInfo1);
//            String uid = request.getHeader("uid");
//            if (!StringUtils.isEmpty(uid)) {
//                List<EnterpriseUser> userList = openService.getAccountByIds(uid);
//                if (!CollectionUtils.isEmpty(userList)) {
//                    userInfo1.setRoleId(userList.get(0).getRoleId());
//                    userInfo1.setEnterpriseUserId(userList.get(0).getId());
//                    userInfo1.setAccountType(getAccountType(userList.get(0)));
//                }
//            }
//            LoginSession.putUser(userInfo1);
//            dataAuth(request.getRequestURI());
//            JedisTool.setEx(cacheKey, JSONObject.toJSONString(userInfo1), 7200);
        }catch (Exception e){
            log.warn("获取用户信息异常",e);
        }
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("接口:{},耗时：{}ms",request.getRequestURI(),System.currentTimeMillis()-startTime);
    }
    @Override
    public void init(FilterConfig filterConfig)throws ServletException {
        log.info("初始化拦截器:{}",filterConfig);

        System.out.println(filterConfig.getInitParameter("name"));
    }



    @Override
    public void destroy() {
        // TODOAuto-generated method stub
        log.info("销毁拦截器");

    }
}
