package com.user.controller;


import com.google.common.collect.Lists;
import com.user.common.result.Result;
import com.user.config.bean.LoginSession;
import com.user.domain.SysRole;
import com.user.domain.SysRoleDept;
import com.user.domain.SysRoleMenu;
import com.user.domain.SysRolePermission;
import com.user.dto.req.RoleReq;
import com.user.dto.req.UserReq;
import com.user.dto.resp.*;
import com.user.service.user.impl.*;
import com.user.util.base.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;
    @Autowired
    SysRoleDeptService sysRoleDeptService;
    @Autowired
    SysRolePermissionService sysRolePermissionService;
    /**
     * 获取用户信息
     */
    @PostMapping(value = "/list")
    public Result<Object> getRoles(@RequestBody RoleReq req) {
        List<RoleVo> roles = sysRoleService.getRoles(req);
        return ResultUtil.OK(roles);
    }
    /**
     * 新增角色
     */
    @PostMapping(value = "/add")
    public Result<Object> addRole(@RequestBody SysRole role) {
        sysRoleService.save(role);
        return ResultUtil.OK();
    }
    /**
     * 修改角色
     */
    @PostMapping(value = "/edit")
    public Result<Object> editRole(@RequestBody SysRole role) {
        sysRoleService.updateById(role);
        return ResultUtil.OK();
    }
    /**
     * 删除角色
     */
    @PostMapping(value = "/dels")
    public Result<Object> delRoles(@RequestBody RoleReq role) {
        sysRoleService.dels(role.getRoleIds());
        return ResultUtil.OK();
    }
    /**
     * 角色菜单操做
     */
    @PostMapping(value = "/menu/list")
    public Result<Object> getRoleMenus(@RequestBody RoleReq req) {
        List<MenuVo> roles = sysRoleMenuService.getRoleMenus(req);
        return ResultUtil.OK(roles);
    }
    /**
     * 角色菜单操做
     */
    @PostMapping(value = "/menu/operate")
    public Result<Object> operateRoleMenu(@RequestBody RoleReq req) {
        sysRoleMenuService.operateRoleMenu(req);
        return ResultUtil.OK();
    }
    /**
     *
     */
    @PostMapping(value = "/dept/list")
    public Result<Object> getRoleDepts(@RequestBody RoleReq req) {
        List<RoleVo> roles = sysRoleDeptService.getRoleDepts(req);
        return ResultUtil.OK(roles);
    }
    /**
     *
     */
    @PostMapping(value = "/dept/operate")
    public Result<Object> operateRoleDept(@RequestBody RoleReq req) {
        sysRoleDeptService.operateRoleDept(req);
        return ResultUtil.OK();
    }
    /**
     *
     */
    @PostMapping(value = "/permission/list")
    public Result<Object> getRolePermissions(@RequestBody RoleReq req) {
        List<PermissionVo> roles = sysRolePermissionService.getRolePermissions(req);
        return ResultUtil.OK(roles);
    }
    /**
     *
     */
    @PostMapping(value = "/permission/operate")
    public Result<Object> operateRolePermission(@RequestBody RoleReq req) {
        sysRolePermissionService.operateRolePermission(req);
        return ResultUtil.OK();
    }
}
