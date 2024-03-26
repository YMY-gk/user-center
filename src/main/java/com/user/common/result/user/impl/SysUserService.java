package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.CommonCode;
import com.user.common.result.PageResult;
import com.user.common.result.Result;
import com.user.config.bean.InitializationBean;
import com.user.config.bean.LoginSession;
import com.user.domain.SysDept;
import com.user.domain.SysRole;
import com.user.domain.SysUser;
import com.user.dto.req.UserReq;
import com.user.dto.resp.DeptTree;
import com.user.dto.resp.DeptVo;
import com.user.dto.resp.RoleVo;
import com.user.dto.resp.UserVo;
import com.user.mapper.SysUserMapper;
import com.user.common.result.user.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.util.base.PageResultUtil;
import com.user.util.base.ResultUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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
    @Autowired
    InitializationBean initializationBean;
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysUserDeptService sysUserDeptService;
    @Override
    public PageResult<UserVo> getPage(UserReq user) {
        Page<UserVo> page = new Page<>(user.getPageIndex(),user.getPageSize());
        Page<UserVo> result= this.baseMapper.queryList(page,user);
        if (CollUtil.isNotEmpty(result.getRecords())){
            buldResult(result.getRecords());
        }
        return PageResultUtil.OK(result);
    }
    public List<UserVo> getList(UserReq user) {
        List<UserVo> result= this.baseMapper.queryList(user);
        if (CollUtil.isNotEmpty(result)){
            buldResult(result);
        }
        return result;
    }
    private void buldResult(List<UserVo> records) {
        List<Long> userId = records.stream().map(UserVo::getUserId).collect(Collectors.toList());
        Map<Long,List<RoleVo>> rolesMap = sysUserRoleService.getListByUserId(userId)
                .stream().collect(Collectors.groupingBy(RoleVo::getUserId));
        Map<Long, List<DeptTree>> deptVosMap = sysUserDeptService.getListByUserId(userId)
                .stream().collect(Collectors.groupingBy(DeptTree::getUserId));
        records.forEach(item->{

            List<RoleVo> roleVos = rolesMap.get(item.getUserId());
            if (CollUtil.isNotEmpty(roleVos)){
                item.setRoleIds(roleVos.stream().map(RoleVo::getRoleId).distinct().collect(Collectors.toList()));
                item.setRoleNames(roleVos.stream().map(RoleVo::getRoleName).distinct().collect(Collectors.joining(",")));
            }
            List<DeptTree> deptTrees= deptVosMap.get(item.getUserId());
            if (CollUtil.isNotEmpty(deptTrees)){
                item.setDeptIds(deptTrees.stream().map(DeptTree::getId).distinct().collect(Collectors.toList()));
                item.setDeptNames(deptTrees.stream().map(DeptTree::getDeptName).distinct().collect(Collectors.joining(",")));
            }
        });
    }



    public SysUser selectByName(String username) {
        return  this.baseMapper.selectByName(username);
    }

    public Result<Object>  addUser(SysUser user) {
        Long realm = LoginSession.getRealm();
        if (realm != 1L && ObjectUtils.isEmpty(user.getUserId())){
            user.setRealmId(realm);
        }
        String  salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String pwd =initializationBean.getCustomPwd()+salt;
        pwd = passwordEncoder.encode(pwd);
        user.setPassword(pwd);
        this.saveOrUpdate(user);
        sysUserRoleService.edit(user.getRoleIds(),user.getUserId());
        sysUserDeptService.edit(user.getDeptIds(),user.getUserId());
        return ResultUtil.OK();
    }
    public Result<Object> updatePwd(Long id, String pwd) {
        SysUser sysUser   = this.baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(sysUser)){
            return ResultUtil.ERROR(CommonCode.RECORD_NO_EXIST);
        }
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
