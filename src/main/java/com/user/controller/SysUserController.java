package com.user.controller;


import com.google.common.collect.Lists;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.config.bean.LoginSession;
import com.user.domain.SysUser;
import com.user.dto.req.UserReq;
import com.user.dto.resp.LoginUserInfo;
import com.user.dto.resp.UserInfoDateil;
import com.user.dto.resp.UserVo;
import com.user.common.result.user.impl.SysUserService;
import com.user.util.base.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
@Api(tags = "员工信息",description = "员工数据")
public class SysUserController {

    @Autowired
    SysUserService userService;
    /**
     * 获取用户信息
     */
    @GetMapping(value = "/userInfo")
    @ApiOperation("获取用户信息")
    public Result<Object> getUserInfo()  {
        LoginUserInfo user = LoginSession.getUser();
        UserInfoDateil userInfo = new UserInfoDateil();
        userInfo.setName(user.getUserName());
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setIntroduction("I am a super administrator");
        userInfo.setRoles(Lists.newArrayList("admin"));
        return ResultUtil.OK(userInfo);

    }
    @PostMapping("/list")
    @ApiOperation("获取员工列表")
    public Result<List<UserVo>> getList(@RequestBody UserReq user){
        return ResultUtil.OK(userService.getList(user));
    }
    @PostMapping("/page")
    @ApiOperation("获取员工分页列表")
    public PageResult<UserVo> getPage(@RequestBody UserReq user){
        return userService.getPage(user);
    }
    @PostMapping("/add")
    @ApiOperation("新增员工数据")
    public Result<Object> addUser(@RequestBody SysUser user){
        return userService.addUser(user);
    }
    @PostMapping("/edit")
    @ApiOperation("编辑员工数据")
    public Result<Object> editUser(@RequestBody SysUser user){
        return userService.addUser(user);
    }
    @PostMapping("/pwd/edit")
    @ApiOperation("修改员工密码")
    public Result<Object> addUser(@RequestParam(value = "id") Long id,@RequestParam(value = "pwd") String pwd){
        return userService.updatePwd(id,pwd);
    }
    @PostMapping("/status")
    @ApiOperation("编辑员工状态")
    public Result<Object> editStatusUser(@RequestParam(value = "id") Long id,@RequestParam(value = "status") Integer status){
        return userService.editStatusUser(id,status);
    }
}
