package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.domain.SysRoleMenu;
import com.user.domain.SysUserDept;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.MenuVo;
import com.user.mapper.SysRoleMenuMapper;
import com.user.common.result.user.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {


    @Override
    public void operateRoleMenu(List<Long> menuIds, Long roleId) {
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleMenu::getRoleId,roleId);
        List<SysRoleMenu> menus = this.baseMapper.selectList(queryWrapper);
        List<Long> dels = menus.stream().filter(x->!menuIds.contains(x.getMenuId())).map(SysRoleMenu::getId).collect(Collectors.toList());
        Map<Long,SysRoleMenu> map = menus.stream()
                .filter(x->menuIds.contains(x.getMenuId()))
                .collect(Collectors.toMap(SysRoleMenu::getMenuId, Function.identity()));
        List<SysRoleMenu> roleMenus = new ArrayList<>();
        if (CollUtil.isNotEmpty(dels)) {
            this.removeByIds(dels);
        }
        menuIds.forEach(item->{
            SysRoleMenu menu = map.get(item);
            if (ObjectUtil.isNotEmpty(menu)){
                roleMenus.add(menu);
                return;
            }
            menu = new SysRoleMenu();
            menu.setMenuId(item).setRoleId(roleId);
            roleMenus.add(menu);
        });
        this.saveOrUpdateBatch(roleMenus);
    }

    @Override
    public List<SysRoleMenu> getListByRoleIds(List<Long> roleIds) {
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysRoleMenu::getRoleId,roleIds);
        List<SysRoleMenu> menus = this.baseMapper.selectList(queryWrapper);
        return menus;
    }

    @Override
    public List<SysRoleMenu> getListByRoleId(Long roleId) {
        return null;
    }

}
