package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.common.result.user.ISysRoleService;
import com.user.domain.SysRole;
import com.user.domain.SysRoleMenu;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.DeptTree;
import com.user.dto.resp.RoleVo;
import com.user.dto.resp.UserVo;
import com.user.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<RoleVo> list   = this.baseMapper.getRoles(req);
        if (CollUtil.isNotEmpty(list)) {
            buldResult(list);
        }
        return list;

    }
    private void buldResult(List<RoleVo> records) {
        List<Long> roleIds = records.stream().map(RoleVo::getRoleId).collect(Collectors.toList());
        Map<Long,List<SysRoleMenu>> rolesMap = sysRoleMenuService.getListByRoleIds(roleIds)
                .stream().collect(Collectors.groupingBy(SysRoleMenu::getRoleId));
        records.forEach(item->{
            List<SysRoleMenu> roleVos = rolesMap.get(item.getRoleId());
            if (CollUtil.isNotEmpty(roleVos)){
                item.setMenuIds(roleVos.stream().map(SysRoleMenu::getMenuId).distinct().collect(Collectors.toList()));
            }
        });
    }
    public void dels(List<Long> roleIds) {
        this.removeByIds(roleIds);
        QueryWrapper<SysRoleMenu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.lambda().in(SysRoleMenu::getRoleId, roleIds);
        sysRoleMenuService.remove(menuQueryWrapper);
    }

    @Override
    public void saveOrEdit(SysRole role) {
        this.saveOrUpdate(role);
        sysRoleMenuService.operateRoleMenu(role.getMenuIds(),role.getRoleId());
    }
}
