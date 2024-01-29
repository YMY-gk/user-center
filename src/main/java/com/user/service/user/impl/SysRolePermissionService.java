package com.user.service.user.impl;

import com.user.domain.SysRolePermission;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.PermissionVo;
import com.user.mapper.SysRolePermissionMapper;
import com.user.service.user.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色和权限关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
@Service
public class SysRolePermissionService extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

    @Override
    public void operateRolePermission(RoleReq req) {

    }

    @Override
    public List<PermissionVo> getRolePermissions(RoleReq req) {
        return null;
    }
}
