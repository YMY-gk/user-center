package com.user.common.result.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.common.result.user.ISysRoleService;
import com.user.domain.SysRole;
import com.user.domain.SysRoleMenu;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.RoleVo;
import com.user.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    SysRoleMenuService sysRoleMenuService;
    @Override
    public List<RoleVo> getRoles(RoleReq req) {
        return this.baseMapper.getRoles(req);
    }

    public void dels(List<Long> roleIds) {
        this.removeByIds(roleIds);
        QueryWrapper<SysRoleMenu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.lambda().in(SysRoleMenu::getRoleId, roleIds);
        sysRoleMenuService.remove(menuQueryWrapper);
    }
}
