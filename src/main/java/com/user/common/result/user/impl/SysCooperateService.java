package com.user.common.result.user.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.CommonConest;
import com.user.common.result.user.ISysCooperateService;
import com.user.domain.SysCooperate;
import com.user.domain.SysDept;
import com.user.domain.SysRole;
import com.user.dto.base.BaseAuth;
import com.user.dto.req.CooperateReq;
import com.user.dto.resp.CooperateVo;
import com.user.mapper.SysCooperateMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 企业表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
 */
@Service
public class SysCooperateService extends ServiceImpl<SysCooperateMapper, SysCooperate> implements ISysCooperateService {

    @Autowired
    SysRoleMapper sysRoleMapper ;
    @Autowired
    SysDeptService sysDeptService ;
    @Override
    public void dels(List<Long> ids) {
        this.removeByIds(ids);
    }

    @Override
    public List<CooperateVo> searchcooperate(CooperateReq req) {
        return this.baseMapper.searchcooperate(req);
    }

    @Override
    public void savecooperate(SysCooperate syscooperate) {
        this.baseMapper.insert(syscooperate);
        SysRole role = new SysRole();
        role.initAdmin(syscooperate.getName(),syscooperate.getId());
        sysRoleMapper.insert(role);
        SysDept dept = new SysDept();
        dept.initAdmin(syscooperate.getId(),syscooperate.getName());
        sysDeptService.save(dept);
    }

    @Override
    public void editcooperate(SysCooperate syscooperate) {
        this.baseMapper.updateById(syscooperate);
        SysRole sysRole =   sysRoleMapper.selectByAdmin(CommonConest.base_admin,syscooperate.getId());
        if (ObjectUtil.isEmpty(sysRole)) {
            SysRole role = new SysRole();
            role.initAdmin(syscooperate.getName(), syscooperate.getId());
            sysRoleMapper.insert(role);
        }
        SysDept dept = sysDeptService.selectByAdmin(CommonConest.treeParentId,syscooperate.getId());
        if (ObjectUtil.isEmpty(dept)) {
            dept = new SysDept();
            dept.initAdmin(syscooperate.getId(),syscooperate.getName());
            sysDeptService.save(dept);
        }
    }

    @Override
    public Page<CooperateVo> searchPagecooperate(CooperateReq req) {
        IPage<CooperateVo> page = new Page<>(req.getPageIndex(),req.getPageSize());
        return this.baseMapper.searchcooperate(page,req);
    }

    @Override
    public void authCooperate(BaseAuth baseAuth) {
        UpdateWrapper<SysCooperate> queryWrapper = new UpdateWrapper<>();
        queryWrapper.lambda().eq(SysCooperate::getId,baseAuth.getId())
                .set(SysCooperate::getAuditState,baseAuth.getStatus())
                .set(SysCooperate::getAuditRemark,baseAuth.getAuditRemark());
         this.update(queryWrapper);
    }
}
