package com.user.controller;


import com.user.common.result.Result;
import com.user.domain.SysCompany;
import com.user.service.user.impl.SysCompanyService;
import com.user.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    private SysCompanyService sysCompanyService;
    @Resource
    HttpServletRequest request;
    @GetMapping("/get")
    public Result< List<SysCompany>> getCompany(){
      // Integer realmId =  request.getIntHeader("realm_id");
        List<SysCompany> company = sysCompanyService.list();
        return ResultUtil.OK(company);
    }

}
