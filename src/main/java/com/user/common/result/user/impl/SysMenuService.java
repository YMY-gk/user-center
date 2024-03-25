package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.user.common.CommonConest;
import com.user.common.result.user.ISysMenuService;
import com.user.domain.SysMenu;
import com.user.dto.req.MenuReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;
import com.user.mapper.SysMenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public MenuVo getMenuById(Long id) {
        MenuVo sysMenu =  this.baseMapper.getMenuById(id);
        return sysMenu;
    }
    @Override
    public List<MenuTree> getMenuByParentId(Long id) {
        List<MenuTree> list   = this.baseMapper.getMenus();
        List<MenuTree> tree = this.recursionTreeApply(list, Lists.newArrayList(id));
        return tree;
    }
    @Override
    public void delid(Long id) {
        List<MenuTree> list   = this.baseMapper.getMenus();
        List<MenuTree> menuList =list.stream().filter(x->id.compareTo(x.getId())==0).collect(Collectors.toList());
        List<MenuTree> tree = this.recursionChildsListApply(list, Lists.newArrayList(id));
        if (CollectionUtil.isNotEmpty(tree)) {
            menuList.addAll(tree);
        }
        List<Long>  ids= menuList.stream().map(MenuTree::getId).collect(Collectors.toList());
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
        List<Long> ids = parentVos.stream().map(MenuTree::getId).collect(Collectors.toList());
        List<MenuTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<MenuTree> tree = this.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<MenuTree> childVos =tree.stream().filter(x->item.getId().compareTo(x.getParentId())==0).collect(Collectors.toList());
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
        List<Long> ids = parentVos.stream().map(MenuTree::getId).collect(Collectors.toList());
        List<MenuTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
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
        List<Long> ids = parentVos.stream().map(MenuTree::getId).collect(Collectors.toList());
        List<MenuTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<MenuTree> tree = this.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<MenuTree> childVos =list.stream().filter(x->item.getId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };

}
