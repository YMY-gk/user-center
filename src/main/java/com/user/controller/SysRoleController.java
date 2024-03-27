package com.user.controller;


import com.user.common.result.Result;
import com.user.common.result.user.impl.SysRoleMenuService;
import com.user.common.result.user.impl.SysRoleService;
import com.user.domain.SysRole;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.*;
import com.user.util.base.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "角色管理",description = "角色信息表")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;
    /**
     * 获取用户信息
     */
    @PostMapping(value = "/list")
    @ApiOperation("获取角色列表")
    public Result<Object> getRoles(@RequestBody RoleReq req) {
        List<RoleVo> roles = sysRoleService.getRoles(req);
        return ResultUtil.OK(roles);
    }
    /**
     * 新增角色
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增角色")
    public Result<Object> addRole(@RequestBody SysRole role) {
        sysRoleService.saveOrEdit(role);
        return ResultUtil.OK();
    }
    /**
     * 修改角色
     */
    @PostMapping(value = "/edit")
    @ApiOperation("修改角色数据")
    public Result<Object> editRole(@RequestBody SysRole role) {
        sysRoleService.saveOrEdit(role);
        return ResultUtil.OK();
    }
    /**
     * 删除角色
     */
    @PostMapping(value = "/dels")
    @ApiOperation("删除角色")
    public Result<Object> delRoles(@RequestBody RoleReq role) {
        sysRoleService.dels(role.getRoleIds());
        return ResultUtil.OK();
    }
    /**
     * 角色菜单操做
     */
    @PostMapping(value = "/menu/list")
    @ApiOperation("获取角色菜单数据")
    public Result<Object> getRoleMenus(@RequestBody RoleReq req) {
        List<MenuVo> roles = sysRoleMenuService.getRoleMenus(req);
        return ResultUtil.OK(roles);
    }
    /**
     * 角色菜单操做
     */
    @PostMapping(value = "/menu/operate")
    @ApiOperation("角色菜单绑定")
    public Result<Object> operateRoleMenu(@RequestBody RoleReq req) {
        sysRoleMenuService.operateRoleMenu(req.getIds(),req.getRoleId());
        return ResultUtil.OK();
    }
}
