package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.user.common.CommonConest;
import com.user.common.result.Result;
import com.user.common.result.user.ISysMenuService;
import com.user.config.bean.InitializationBean;
import com.user.config.bean.LoginSession;
import com.user.domain.SysMenu;
import com.user.domain.SysRole;
import com.user.dto.req.MenuReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;
import com.user.mapper.SysMenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.util.base.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    InitializationBean initializationBean;
    @Resource
    SysRoleService sysRoleService;

    @Override
    public void addMenu(SysMenu menu) {
        this.save(menu);
    }

    @Override
    public void editMenu(SysMenu menu) {
        this.updateById(menu);
    }

    @Override
    public List<MenuTree> getInitMenus(Long roleId) {
        Long realmId = LoginSession.getRealm();
        SysRole role = new SysRole();
        //1、roleid不为空
        if (ObjectUtil.isNotEmpty(roleId)){
            role = sysRoleService.getById(roleId);
            realmId = role.getRealmId();
            if (role.getIsAdmin().compareTo(CommonConest.base_admin)==0){
                return this.getMenus();
            }
            List<MenuTree> list   = this.baseMapper.getInitMenus(realmId);
            List<MenuTree> tree = this.recursionTreeApply(list, Lists.newArrayList(CommonConest.treeParentId));
            return tree;
        }

        //2且roleid为空
        if (ObjectUtil.isEmpty(realmId)){
            return this.getMenus();
        }
        List<MenuTree> list   = this.baseMapper.getInitMenus(realmId);
        List<MenuTree> tree = this.recursionTreeApply(list, Lists.newArrayList(CommonConest.treeParentId));
        return tree;
    }

    @Override
    public List<MenuTree> getMenus() {
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
    public List<MenuTree> getRoleMenus(Long realmId) {
        List<MenuTree> list = new ArrayList<>();
        if (realmId.compareTo(1L) == 0){
            list   = this.baseMapper.getMenus();
        }else {
            list   = this.baseMapper.getRoleMenus(realmId);
        }
        List<MenuTree> tree = this.recursionTreeApply(list, Lists.newArrayList(CommonConest.treeParentId));
        return tree;
    }

    @Override
    public Result<List<MenuTree>> getRoleMenusByUser() {
        List<Long> roles = LoginSession.getUser().getRoles();
        String userName =LoginSession.getUserName();
        if (CollUtil.isEmpty(roles)&&!initializationBean.getUserName().equals(userName)){
            return  ResultUtil.OK();
        }
        List<MenuTree> list   = this.baseMapper.getRoleMenusByUser(roles,LoginSession.getRealm());
        if (CollUtil.isEmpty(list)){
            return  ResultUtil.OK();
        }
        List<String> permissions = list.stream().map(MenuTree::getPerms).distinct().collect(Collectors.toList());
        List<String> menuTypes = Lists.newArrayList("C","M");
        List<MenuTree> tree = this.recursionTreeApply(list.stream().filter(x->menuTypes.contains(x.getMenuType())).collect(Collectors.toList()),
                Lists.newArrayList(CommonConest.treeParentId));
        return ResultUtil.OK(tree.get(0).getChilds(),permissions);
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
