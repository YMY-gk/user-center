package com.user.service.oauth.impl;

import com.user.domain.SysUser;
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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long realm =1L;
//        SysUser user = sysUserService.selectByName(username,realm);
//        if (ObjectUtils.isEmpty(user)|| StringUtils.isEmpty(user.getPassword())){
//
//            throw new UsernameNotFoundException("用户名/密码不存在！");
//        }
       // String pwd =user.getPassword();//user.getData().getPassword();
        // 第三个参数表示权限
        return new User(username,new BCryptPasswordEncoder().encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("user,ROLE_role1"));
    }
}
