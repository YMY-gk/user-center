package com.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.domain.SysCooperate;
import com.user.dto.req.CooperateReq;
import com.user.dto.resp.CooperateVo;
import com.user.service.user.impl.SysCooperateService;
import com.user.util.base.PageResultUtil;
import com.user.util.base.ResultUtil;
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
public class SysCooperateController {

    @Autowired
    private SysCooperateService sysCooperateService;
    @Resource
    HttpServletRequest request;
    @GetMapping("/get")
    public Result< List<SysCooperate>> getcooperate(@RequestParam(required = true,value = "id")  Long id){
        List<SysCooperate> cooperate = sysCooperateService.list();
        return ResultUtil.OK(cooperate);
    }
    @PostMapping("/list")
    public Result< List<CooperateVo>> searchcooperate(@RequestBody CooperateReq req  ){
        List<CooperateVo> cooperate = sysCooperateService.searchcooperate(req);
        return ResultUtil.OK(cooperate);
    }
    @PostMapping("/page")
    public PageResult< CooperateVo> searchPagecooperate(@RequestBody CooperateReq req  ){
        Page<CooperateVo> cooperates = sysCooperateService.searchPagecooperate(req);
        return PageResultUtil.OK(cooperates);
    }
    @PostMapping("/add")
    public Result<Objects> savecooperate(@RequestBody SysCooperate syscooperate ){
        sysCooperateService.savecooperate(syscooperate);
        return ResultUtil.OK();
    }
    @PostMapping("/edit")
    public Result<Objects> editcooperate(@RequestBody SysCooperate syscooperate ){
        sysCooperateService.editcooperate(syscooperate);
        return ResultUtil.OK();
    }
    @PostMapping("/dels")
    public Result<Objects> delcooperate(@RequestParam List<Long> ids ){
        sysCooperateService.dels(ids);
        return ResultUtil.OK();
    }
}
