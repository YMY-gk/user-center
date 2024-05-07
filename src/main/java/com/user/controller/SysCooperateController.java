package com.user.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.CommonCode;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.config.bean.LoginSession;
import com.user.domain.SysCooperate;
import com.user.dto.base.BaseAuth;
import com.user.dto.req.CooperateReq;
import com.user.dto.resp.CooperateVo;
import com.user.common.result.user.impl.SysCooperateService;
import com.user.util.base.PageResultUtil;
import com.user.util.base.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 公司表 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@RestController
@RequestMapping("/cooperate")
@Api(tags = "合作平台",description = "操做合作平台")
public class SysCooperateController {

    @Autowired
    private SysCooperateService sysCooperateService;
    @Resource
    HttpServletRequest request;
    @GetMapping("/get")
    @ApiOperation("根据Id获取合作")
    public Result< List<SysCooperate>> getcooperate(@RequestParam(required = true,value = "id")  Long id){
        List<SysCooperate> cooperate = sysCooperateService.list();
        return ResultUtil.OK(cooperate);
    }
    @PostMapping("/list")
    @ApiOperation("获取全部合作")
    public Result< List<CooperateVo>> searchcooperate(@RequestBody CooperateReq req  ){
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)){
            req.setId(realmId);
        }
        List<CooperateVo> cooperate = sysCooperateService.searchcooperate(req);
        return ResultUtil.OK(cooperate);
    }
    @PostMapping("/page")
    @ApiOperation("获取全部合作")
    public PageResult< CooperateVo> searchPagecooperate(@RequestBody CooperateReq req  ){
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)){
            req.setId(realmId);
        }
        Page<CooperateVo> cooperates = sysCooperateService.searchPagecooperate(req);
        return PageResultUtil.OK(cooperates);
    }
    @PostMapping("/add")
    @ApiOperation("添加合作")
    public Result<Objects> savecooperate(@RequestBody SysCooperate syscooperate ){
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)){
            return ResultUtil.ERROR(CommonCode.PERMISSION_NO_ERROR);
        }
        sysCooperateService.savecooperate(syscooperate);
        return ResultUtil.OK();
    }
    @PostMapping("/edit")
    @ApiOperation("编辑合作")
    public Result<Objects> editcooperate(@RequestBody SysCooperate syscooperate ){
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)){
            return ResultUtil.ERROR(CommonCode.PERMISSION_NO_ERROR);
        }
        sysCooperateService.editcooperate(syscooperate);
        return ResultUtil.OK();
    }
    @PostMapping("/dels")
    @ApiOperation("删除合作")
    public Result<Objects> delcooperate(@RequestParam List<Long> ids ){
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)){
            return ResultUtil.ERROR(CommonCode.PERMISSION_NO_ERROR);
        }
        sysCooperateService.dels(ids);
        return ResultUtil.OK();
    }
    @PostMapping("/auth")
    @ApiOperation("审批合作数据")
    public Result<Objects> authCooperate(@RequestBody BaseAuth baseAuth  ){
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)){
            return ResultUtil.ERROR(CommonCode.PERMISSION_NO_ERROR);
        }
        sysCooperateService.authCooperate(baseAuth);
        return ResultUtil.OK();
    }
}
