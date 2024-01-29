package com.user.service.user.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.user.common.CommonConest;
import com.user.domain.SysMenu;
import com.user.dto.req.MenuReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;
import com.user.mapper.SysMenuMapper;
import com.user.service.user.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<MenuTree> getMenus(MenuReq req) {
        List<MenuTree> list   = this.baseMapper.getMenus();
        List<MenuTree> tree = this.recursionTreeApply(list, Lists.newArrayList(CommonConest.treeParentId));
        return tree;
    }

    @Override
    public MenuVo getMenuById(Long menuId) {
        MenuVo sysMenu =  this.baseMapper.getMenuById(menuId);
        return sysMenu;
    }
    @Override
    public List<MenuTree> getMenuByParentId(Long menuId) {
        List<MenuTree> list   = this.baseMapper.getMenus();
        List<MenuTree> tree = this.recursionTreeApply(list, Lists.newArrayList(menuId));
        return tree;
    }
    @Override
    public void delMenuId(Long menuId) {
        List<MenuTree> list   = this.baseMapper.getMenus();
        List<MenuTree> menuList =list.stream().filter(x->menuId.compareTo(x.getMenuId())==0).collect(Collectors.toList());
        List<MenuTree> tree = this.recursionChildsListApply(list, Lists.newArrayList(menuId));
        if (CollectionUtil.isNotEmpty(tree)) {
            menuList.addAll(tree);
        }
        List<Long>  ids= menuList.stream().map(MenuTree::getMenuId).collect(Collectors.toList());
        this.baseMapper.deleteBatchIds(ids);

    }

    /**
     * 递归整理菜单
     */
    List<MenuTree> recursionTreeApply(List<MenuTree> list, List<Long> parentIds){
        List<MenuTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(MenuTree::getMenuId).collect(Collectors.toList());
        List<MenuTree> residue  =list.stream().filter(x->!ids.contains(x.getMenuId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<MenuTree> tree = this.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<MenuTree> childVos =tree.stream().filter(x->item.getMenuId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };

    /**
     * 递归整理子菜单
     */
    List<MenuTree> recursionChildsListApply(List<MenuTree> list, List<Long> parentIds){
        List<MenuTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(MenuTree::getMenuId).collect(Collectors.toList());
        List<MenuTree> residue  =list.stream().filter(x->!ids.contains(x.getMenuId())).collect(Collectors.toList());
        List<MenuTree> tree = this.recursionChildsListApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.addAll(tree);
        return parentVos;
    };
    /**
     * 递归以子集返回菜单树集合
     */
    List<MenuTree> recursionChildsTreeApply(List<MenuTree> list, List<Long> parentIds){
        List<MenuTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(MenuTree::getMenuId).collect(Collectors.toList());
        List<MenuTree> residue  =list.stream().filter(x->!ids.contains(x.getMenuId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<MenuTree> tree = this.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<MenuTree> childVos =list.stream().filter(x->item.getMenuId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };

}
