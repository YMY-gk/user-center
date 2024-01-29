package com.user.controller;


import com.user.common.result.Result;
import com.user.domain.SysMenu;
import com.user.domain.SysRole;
import com.user.dto.req.MenuReq;
import com.user.dto.req.RoleReq;
import com.user.dto.req.UserReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;
import com.user.dto.resp.PermissionVo;
import com.user.dto.resp.RoleVo;
import com.user.service.user.impl.SysMenuPermissionService;
import com.user.service.user.impl.SysMenuService;
import com.user.service.user.impl.SysRoleDeptService;
import com.user.service.user.impl.SysRoleService;
import com.user.util.base.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysMenuPermissionService sysMenuPermissionService;
    /**
     * 获取菜单
     */
    @PostMapping(value = "/list")
    public Result<List<MenuTree> > getMenus(@RequestBody MenuReq req) {
        List<MenuTree>  sysMenus= sysMenuService.getMenus(req);
        return ResultUtil.OK(sysMenus);
    }
    @GetMapping(value = "/get")
    public Result<MenuVo > getMenuById(@RequestParam(required = true,value = "menuId") Long  menuId) {
        MenuVo  sysMenus= sysMenuService.getMenuById(menuId);
        return ResultUtil.OK(sysMenus);
    }
    @GetMapping(value = "/childs/get")
    public Result<List<MenuTree> > getMenuByParentId(@RequestParam(required = true,value = "menuId") Long  menuId) {
        List<MenuTree>  sysMenus = sysMenuService.getMenuByParentId(menuId);
        return ResultUtil.OK(sysMenus);
    }
    /**
     * 新增菜单
     */
    @PostMapping(value = "/add")
    public Result<Object> addRole(@RequestBody SysMenu menu) {
        sysMenuService.save(menu);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @PostMapping(value = "/edit")
    public Result<Object> editRole(@RequestBody SysMenu menu) {
        sysMenuService.updateById(menu);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @GetMapping(value = "/del")
    public Result<Object> delMenuId(@RequestParam(required = true,value = "menuId") Long  menuId) {
        sysMenuService.delMenuId(menuId);
        return ResultUtil.OK();
    }
    /**
     * 获取菜单权限
     */
    @PostMapping(value = "/permission/list")
    public Result<Object> getRolePermissions(@RequestBody MenuReq req) {
        List<PermissionVo> roles = sysMenuPermissionService.getRolePermissions(req);
        return ResultUtil.OK(roles);
    }
    /**
     *编辑菜单权限
     */
    @PostMapping(value = "/permission/operate")
    public Result<Object> operateRolePermission(@RequestBody MenuReq req) {
        sysMenuPermissionService.operateRolePermission(req);
        return ResultUtil.OK();
    }
}
