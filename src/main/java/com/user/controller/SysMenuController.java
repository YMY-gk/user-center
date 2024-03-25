package com.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.domain.SysMenu;
import com.user.dto.req.MenuReq;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;
import com.user.dto.resp.PermissionVo;
import com.user.common.result.user.impl.SysMenuPermissionService;
import com.user.common.result.user.impl.SysMenuService;
import com.user.util.base.PageResultUtil;
import com.user.util.base.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "菜单数据",description = "菜单数据操做")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysMenuPermissionService sysMenuPermissionService;
    /**
     * 获取菜单
     */
    @PostMapping(value = "/list")
    @ApiOperation("获取菜单列表")
    public Result<List<MenuTree> > getMenus(@RequestBody MenuReq req) {
        List<MenuTree>  sysMenus= sysMenuService.getMenus(req);
        return ResultUtil.OK(sysMenus);
    }
    @GetMapping(value = "/get")
    @ApiOperation("获取菜单详情")
    public Result<MenuVo > getMenuById(@RequestParam(required = true,value = "id") Long  id) {
        MenuVo  sysMenus= sysMenuService.getMenuById(id);
        return ResultUtil.OK(sysMenus);
    }
    @GetMapping(value = "/childs/get")
    @ApiOperation("获取子菜单列表")
    public Result<List<MenuTree> > getMenuByParentId(@RequestParam(required = true,value = "id") Long  id) {
        List<MenuTree>  sysMenus = sysMenuService.getMenuByParentId(id);
        return ResultUtil.OK(sysMenus);
    }
    /**
     * 新增菜单
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增菜单数据")
    public Result<Object> addRole(@RequestBody SysMenu menu) {
        sysMenuService.save(menu);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @PostMapping(value = "/edit")
    @ApiOperation("编辑菜单数据")
    public Result<Object> editRole(@RequestBody SysMenu menu) {
        sysMenuService.updateById(menu);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @GetMapping(value = "/del")
    @ApiOperation("删除菜单数据")
    public Result<Object> delid(@RequestParam(required = true,value = "id") Long  id) {
        sysMenuService.delid(id);
        return ResultUtil.OK();
    }
    /**
     * 获取菜单权限
     */
    @PostMapping(value = "/permission/list")
    @ApiOperation("获取菜单权限")
    public PageResult<PermissionVo> getRolePermissions(@RequestBody PermissionReq req) {
        Page<PermissionVo> roles = sysMenuPermissionService.getRolePermissions(req);
        return PageResultUtil.OK(roles);
    }
    /**
     *编辑菜单权限
     */
    @PostMapping(value = "/permission/operate")
    @ApiOperation("编辑菜单权限")
    public Result<Object> operateRolePermission(@RequestBody MenuReq req) {
        sysMenuPermissionService.operateRolePermission(req);
        return ResultUtil.OK();
    }
    @PostMapping(value = "/permission/del")
    @ApiOperation("编辑菜单权限")
    public Result<Object> delPermission(@RequestBody MenuReq req) {
        sysMenuPermissionService.delPermission(req);
        return ResultUtil.OK();
    }
}
