package com.user.service.user.impl;

import com.user.domain.SysUser;
import com.user.mapper.SysUserMapper;
import com.user.service.user.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    public SysUser selectByName(String username, Long realm) {
        return  this.baseMapper.selectByName(username,realm);
    }
}
