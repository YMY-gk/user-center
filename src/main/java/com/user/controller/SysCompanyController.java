package com.user.controller;


import com.user.common.result.Result;
import com.user.domain.SysCompany;
import com.user.service.user.ISysCompanyService;
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
@RequestMapping("/sys-company")
public class SysCompanyController {

    @Autowired
    private ISysCompanyService sysCompanyService;
    @Resource
    HttpServletRequest request;
    @GetMapping("/get")
    public Result< List<SysCompany>> getCompany(){
        List<SysCompany> company = sysCompanyService.list();
        return ResultUtil.OK(company);
    }
    @PostMapping("/list")
    public Result< List<SysCompany>> searchCompany(){
        List<SysCompany> company = sysCompanyService.list();
        return ResultUtil.OK(company);
    }
    @PostMapping("/add")
    public Result<Objects> saveCompany(@RequestBody SysCompany sysCompany ){
        sysCompanyService.inset(sysCompany);
        return ResultUtil.OK();
    }
    @PostMapping("/dels")
    public Result<Objects> delCompany(@RequestParam List<Long> ids ){
        sysCompanyService.dels(ids);
        return ResultUtil.OK();
    }
}
