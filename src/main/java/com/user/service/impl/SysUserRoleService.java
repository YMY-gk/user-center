package com.user.service.impl;

import com.user.domain.SysUserRole;
import com.user.mapper.SysUserRoleMapper;
import com.user.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
