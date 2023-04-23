package com.user.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.CommonCode;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.domain.SysUser;
import com.user.dto.req.UserReq;
import com.user.dto.resp.UserVo;
import com.user.mapper.SysUserMapper;
import com.user.service.user.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.util.PageResultUtil;
import com.user.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Value("initialization.password")
    private  String password;


    public PageResult<SysUser> getList(UserReq user) {
        Page<SysUser> page = new Page<>(user.getPageIndex(),user.getPageSize());
        QueryWrapper<SysUser> userQueryWrapper  = new QueryWrapper<>();

        userQueryWrapper.lambda().eq(ObjectUtils.isNotEmpty(user.getUserId()),SysUser::getUserId,user.getUserId())
                .eq(ObjectUtils.isNotEmpty(user.getPhonenumber()),SysUser::getPhonenumber,user.getPhonenumber());
        Page<SysUser>  result= this.baseMapper.selectPage(page,userQueryWrapper);
        return PageResultUtil.OK(result);
    }
    public SysUser selectByName(String username, Long realm) {
        return  this.baseMapper.selectByName(username,realm);
    }

    public Result<Object>  addUser(SysUser user) {
        String  salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String pwd =passwordEncoder+salt;
        pwd = passwordEncoder.encode(pwd);
        user.setPassword(pwd);
        this.baseMapper.insert(user);
        return ResultUtil.OK();
    }
    public Result<Object> updatePwd(Long id, String pwd) {
        SysUser sysUser   = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(sysUser)){
            return ResultUtil.ERROR(CommonCode.RECORD_NO_EXIST);
        }
        String  salt = UUID.randomUUID().toString();
        sysUser.setSalt(salt);
        pwd =pwd+salt;
        pwd = passwordEncoder.encode(pwd);
        sysUser.setPassword(pwd);
        String user= passwordEncoder.encode(pwd);
        this.baseMapper.updateById(sysUser);
        return ResultUtil.OK();
    }

    public Result<Object> editStatusUser(Long id, Integer status) {
        SysUser sysUser   = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(sysUser)){
            return ResultUtil.ERROR(CommonCode.RECORD_NO_EXIST);
        }
        sysUser.setStatus(status);
        this.baseMapper.updateById(sysUser);
        return ResultUtil.OK();
    }
}
