package com.user.controller;


import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.domain.SysUser;
import com.user.dto.req.UserReq;
import com.user.service.user.impl.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    SysUserService userService;

    @PostMapping("/list")
    public PageResult<SysUser> getList(@RequestBody UserReq user){
        return userService.getList(user);
    }
    @PostMapping("/add")
    public Result<Object> addUser(@RequestBody SysUser user){
        return userService.addUser(user);
    }
    @PostMapping("/edit")
    public Result<Object> editUser(@RequestBody SysUser user){
        return userService.addUser(user);
    }
    @PostMapping("/pwd/edit")
    public Result<Object> addUser(@RequestParam(value = "id") Long id,@RequestParam(value = "pwd") String pwd){
        return userService.updatePwd(id,pwd);
    }
    @PostMapping("/status")
    public Result<Object> editStatusUser(@RequestParam(value = "id") Long id,@RequestParam(value = "status") Integer status){
        return userService.editStatusUser(id,status);
    }

}
