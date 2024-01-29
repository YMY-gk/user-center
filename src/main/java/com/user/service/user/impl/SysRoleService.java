package com.user.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.domain.SysRole;
import com.user.domain.SysRoleDept;
import com.user.domain.SysRoleMenu;
import com.user.domain.SysRolePermission;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.RoleVo;
import com.user.mapper.SysRoleMapper;
import com.user.service.user.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    SysRoleMenuService sysRoleMenuService;
    @Autowired
    SysRoleDeptService sysRoleDeptService;
    @Autowired
    SysRolePermissionService sysRolePermissionService;
    @Override
    public List<RoleVo> getRoles(RoleReq req) {
        return this.baseMapper.getRoles(req);
    }

    public void dels(List<Long> roleIds) {
        this.removeByIds(roleIds);
        QueryWrapper<SysRoleMenu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.lambda().in(SysRoleMenu::getRoleId, roleIds);
        sysRoleMenuService.remove(menuQueryWrapper);
        QueryWrapper<SysRoleDept> deptQueryWrapper = new QueryWrapper<>();
        deptQueryWrapper.lambda().in(SysRoleDept::getRoleId, roleIds);
        sysRoleDeptService.remove(deptQueryWrapper);
        QueryWrapper<SysRolePermission> permissionQueryWrapper  = new QueryWrapper<>();
        permissionQueryWrapper.lambda().in(SysRolePermission::getRoleId, roleIds);
        sysRolePermissionService.remove(permissionQueryWrapper);
    }
}
