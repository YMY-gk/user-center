package com.user.controller;


import com.user.common.CommonConest;
import com.user.common.result.Result;
import com.user.config.bean.LoginSession;
import com.user.domain.SysDept;
import com.user.dto.req.DeptReq;
import com.user.dto.resp.DeptTree;
import com.user.common.result.user.ISysDeptService;
import com.user.util.base.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@RestController
@RequestMapping("/dept")
@Api(tags = "部门管理",description = "操做部门数据")
public class SysDeptController {
    @Autowired
    ISysDeptService sysDeptService;
    @Autowired
    private HttpServletRequest request;
    /**
     * 获取部门列表信息
     */
    @PostMapping(value = "/tree")
    @ApiOperation("获取部门列表信息")
    public Result<List<DeptTree> > getDepts(@RequestBody DeptReq req) {
        Long realmId = LoginSession.getRealm();
        if (realmId.compareTo(CommonConest.base_realm)!=0){
            req.setRealmId(realmId);
        }
        List<DeptTree>  sysMenus= sysDeptService.getDepts(req);
        return ResultUtil.OK(sysMenus);
    }
    @PostMapping(value = "/list")
    @ApiOperation("获取部门列表信息")
    public Result<List<DeptTree> > getDeptLists(@RequestBody DeptReq req) {
        Long realmId = LoginSession.getRealm();
        if (realmId.compareTo(CommonConest.base_realm)!=0){
            req.setRealmId(realmId);
        }
        List<DeptTree>  sysMenus= sysDeptService.getDeptLists(req);
        return ResultUtil.OK(sysMenus);
    }
    @GetMapping(value = "/get")
    @ApiOperation("根据Id获取部门信息")
    public Result<DeptTree > getDeptById(@RequestParam(required = true,value = "id") Long  id) {
        DeptTree  deptTree= sysDeptService.getDeptById(id);
        return ResultUtil.OK(deptTree);
    }
    @GetMapping(value = "/childs/get")
    @ApiOperation("根据部门id获取子部门数据")
    public Result<List<DeptTree> > getDeptByParentId(@RequestParam(required = true,value = "id") Long  id) {
        Long realmId = LoginSession.getRealm();
        List<DeptTree>  sysMenus = sysDeptService.getDeptByParentId(id,realmId);
        return ResultUtil.OK(sysMenus);
    }
    /**
     * 新增菜单
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增部门信息")
    public Result<Object> addDept(@RequestBody SysDept sysDept) {

        Long realmId = LoginSession.getRealm();
        if (realmId.compareTo(1L)!=0){
            sysDept.setRealmId(realmId);
        }

        sysDeptService.save(sysDept);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @PostMapping(value = "/edit")
    @ApiOperation("编辑部门")
    public Result<Object> editDept(@RequestBody SysDept sysDept) {
        sysDeptService.updateById(sysDept);
        return ResultUtil.OK();
    }
    /**
     * 修改菜单
     */
    @GetMapping(value = "/del")
    @ApiOperation("删除部门数据")
    public Result<Object> delDeptId(@RequestParam(required = true,value = "id") Long  id) {
        Long realmId = LoginSession.getRealm();
        sysDeptService.delDeptId(id,realmId);
        return ResultUtil.OK();
    }
}
