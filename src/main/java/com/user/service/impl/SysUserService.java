package com.user.service.impl;

import com.user.domain.SysUser;
import com.user.mapper.SysUserMapper;
import com.user.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
