package com.user.service.oauth.impl;

import cn.hutool.core.bean.BeanUtil;
import com.user.config.Handler.UserInfo;
import com.user.config.bean.InitializationBean;
import com.user.domain.SysUser;
import com.user.dto.resp.LoginUserInfo;
import com.user.service.user.impl.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guokui
 * @class security
 * @date 2021/9/2 17:06
 */
@Service("UserDetailsService")
@Slf4j
public class MyUserDetialService implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;
    @Resource
    HttpServletRequest request;
    @Resource
    InitializationBean initializationBean;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long realm =1L;
        LoginUserInfo userInfo = new LoginUserInfo();
        if (initializationBean.getUserName().equals(username)){
           User user =  new UserInfo(username,new BCryptPasswordEncoder().encode(initializationBean.getPassword()),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("admin"),userInfo);
            return user;
        }
        SysUser user = sysUserService.selectByName(username);
        if (ObjectUtils.isEmpty(user)|| StringUtils.isEmpty(user.getPassword())){

            throw new UsernameNotFoundException("用户名/密码不存在！");
        }
        BeanUtil.copyProperties(user,userInfo);
       // String pwd =user.getPassword();//user.getData().getPassword();
        // 第三个参数表示权限
        User useinfo  =  new UserInfo<LoginUserInfo>(username,new BCryptPasswordEncoder().encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("user,ROLE_role1"),userInfo);
        return useinfo;

    }
}
