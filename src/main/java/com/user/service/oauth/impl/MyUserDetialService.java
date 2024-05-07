package com.user.service.oauth.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.user.common.result.user.impl.SysUserRoleService;
import com.user.config.Handler.UserInfo;
import com.user.config.bean.InitializationBean;
import com.user.domain.SysUser;
import com.user.dto.resp.LoginUserInfo;
import com.user.common.result.user.impl.SysUserService;
import com.user.dto.resp.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Resource
    InitializationBean initializationBean;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUserInfo userInfo = new LoginUserInfo();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (initializationBean.getUserName().equals(username)){
            userInfo.setRealmId(1L);
            userInfo.setUserName(username);
            List<String> list = sysUserRoleService.getPByRoleIds(null);
            User user =  new UserInfo(username,new BCryptPasswordEncoder().encode(initializationBean.getPassword()),
                    AuthorityUtils.commaSeparatedStringToAuthorityList(list.stream().collect(Collectors.joining(","))),userInfo);
            return user;
        }
        SysUser user = sysUserService.selectByName(username);
        if (ObjectUtils.isEmpty(user)|| StringUtils.isEmpty(user.getPassword())){
            throw new UsernameNotFoundException("用户名/密码不存在！");
        }
        List<RoleVo> roleVos = sysUserRoleService.getListByUserId(user.getUserId());
        BeanUtil.copyProperties(user,userInfo);
        if (CollUtil.isNotEmpty(roleVos)) {
            userInfo.setRoles(roleVos.stream().map(RoleVo::getRoleId).collect(Collectors.toList()));
        }
        if (CollUtil.isNotEmpty(userInfo.getRoles())){
            List<String> list = sysUserRoleService.getPByRoleIds(userInfo.getRoles());
            if (CollUtil.isNotEmpty(list)) {
                grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(list.stream().collect(Collectors.joining(","))));
            }
        }
        // 第三个参数表示权限
        User useinfo  =  new UserInfo<LoginUserInfo>(username,user.getPassword(),
                grantedAuthorities,userInfo);
        return useinfo;

    }
}
