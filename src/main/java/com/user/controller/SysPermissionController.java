package com.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.common.result.user.impl.SysMenuPermissionService;
import com.user.domain.SysPermission;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;
import com.user.common.result.user.impl.SysPermissionService;
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
@RequestMapping("/permission")
@Api(tags = "接口数据",description = "接口数据")
public class SysPermissionController {
    @Autowired
    SysPermissionService sysPermissionService;
    /**
     * 获取菜单
     */
    @PostMapping(value = "/page")
    @ApiOperation("获取接口列表")
    public PageResult<PermissionVo> page(@RequestBody PermissionReq req) {
        Page<PermissionVo> page= sysPermissionService.pagePermissions(req);
        return PageResultUtil.OK(page);
    }
    /**
     * 新增菜单
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增接口数据")
    public Result<Object> addRole(@RequestBody SysPermission permission) {

        sysPermissionService.save(permission);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @PostMapping(value = "/edit")
    @ApiOperation("编辑接口数据")
    public Result<Object> editRole(@RequestBody SysPermission permission) {
        sysPermissionService.updateById(permission);
        return ResultUtil.OK();
    }
    /**
     * 获取菜单
     */
    @PostMapping(value = "/get")
    @ApiOperation("获取接口数据")
    public Result<SysPermission> get(@RequestParam(required = true,value = "id") Long  id) {
        SysPermission permission= sysPermissionService.getById(id);
        return ResultUtil.OK(permission);
    }
    /**
     * 删除
     */
    @PostMapping(value = "/dels")
    @ApiOperation("删除接口数据")
    public Result<SysPermission> dels(@RequestParam(required = true,value = "ids") List<Long>  ids) {
        sysPermissionService.removeByIds(ids);
        return ResultUtil.OK();
    }
    /**
     * 获取菜单权限
     */
    @PostMapping(value = "/menu/list")
    @ApiOperation("获取菜单权限")
    public PageResult<PermissionVo> getNotMenuPermissions(@RequestBody PermissionReq req) {
        Page<PermissionVo> roles = sysPermissionService.getNotMenuPermissions(req);
        return PageResultUtil.OK(roles);
    }
}
