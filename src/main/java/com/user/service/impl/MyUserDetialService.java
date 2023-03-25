package com.user.service.impl;

import com.user.domain.SysUser;
import com.user.service.impl.SysUserService;
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

/**
 * @author guokui
 * @class security
 * @date 2021/9/2 17:06
 */
@Service("UserDetailsService")
@Slf4j
public class MyUserDetialService implements UserDetailsService {
    @Autowired
    private SysUserService loginClient;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        SysUser user =loginClient.getById(username);

        // 判断用户名是否存在
        if (ObjectUtils.isEmpty(user)){
            log.error("-----------------------------loadUserByUsername-----------------------------------");
            throw new UsernameNotFoundException("用户名不存在！");
        }
        // 从数据库中获取的密码 atguigu 的密文
        String pwd ="lisi";//user.getData().getPassword();
        user.setPassword(pwd);
        // 第三个参数表示权限
        return new User(username,new BCryptPasswordEncoder().encode(pwd), AuthorityUtils.commaSeparatedStringToAuthorityList("user,ROLE_role1"));
    }
}
