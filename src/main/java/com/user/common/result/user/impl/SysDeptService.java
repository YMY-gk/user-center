package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.user.common.CommonConest;
import com.user.common.result.Result;
import com.user.common.result.user.ISysDeptService;
import com.user.config.bean.LoginSession;
import com.user.domain.SysDept;
import com.user.dto.req.DeptReq;
import com.user.dto.resp.DeptTree;
import com.user.mapper.SysDeptMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.util.base.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysDeptService extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {



    @Override
    public Result<Object> addDept(SysDept sysDept) {
        this.save(sysDept);
        return ResultUtil.OK();
    }

    @Override
    public Result<Object> editDept(SysDept sysDept) {
        SysDept dept = this.getById(sysDept.getId());
        Long realmId = LoginSession.getRealm();
        if (ObjectUtil.isNotEmpty(realmId)&&dept.getRealmId().compareTo(realmId)!=0){
            return ResultUtil.ERROR(202,null,"操做记录不存在");
        }
        if (dept.getRealmId()!=sysDept.getRealmId()){
            return ResultUtil.ERROR(202,null,"操做记录不存在");
        }
        this.updateById(sysDept);
        return ResultUtil.OK();
    }
    @Override
    public List<DeptTree> getDepts(DeptReq req) {
        List<DeptTree> list   = this.baseMapper.getDepts(req.getRealmId());
        List<DeptTree> tree = this.recursionTreeApply(list, Lists.newArrayList(CommonConest.treeParentId));
        return tree;
    }
    @Override
    public List<DeptTree> getDeptLists(DeptReq req) {
        List<DeptTree> list   = this.baseMapper.getDepts(req.getRealmId());
        return list;
    }

    @Override
    public List<Long> getDeptsById(Long deptId, Long realmId) {
        List<DeptTree> list   = this.baseMapper.getDeptByParentId(realmId);
        List<Long> tree = this.recursionTreeApplyIds(list, Lists.newArrayList(deptId));
        return tree;
    }

    private List<Long> recursionTreeApplyIds(List<DeptTree> list, List<Long> parentIds) {
        List<DeptTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return parentIds;
        }
        List<Long> ids = parentVos.stream().map(DeptTree::getId).collect(Collectors.toList());
        List<DeptTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
             parentIds.addAll(ids);
             return  parentIds;
        }
        List<Long> tree = this.recursionTreeApplyIds(residue,ids);
        parentIds.addAll(tree);
        return parentIds;
    }

    @Override
    public DeptTree getDeptById(Long id) {
        DeptTree deptTree =  this.baseMapper.getDeptById(id,LoginSession.getRealm());
        return deptTree;
    }

    @Override
    public List<DeptTree> getDeptByParentId(Long id, Long realmId) {
        List<DeptTree> list   = this.baseMapper.getDeptByParentId(realmId);
        List<DeptTree> tree = this.recursionTreeApply(list, Lists.newArrayList(id));
        return tree;
    }

    @Override
    public void delDeptId(Long id,Long realmId) {
        List<DeptTree> list   = this.baseMapper.getDepts(realmId);
        List<DeptTree> menuList =list.stream().filter(x->id.compareTo(x.getId())==0).collect(Collectors.toList());
        List<DeptTree> tree = this.recursionChildsListApply(list, Lists.newArrayList(id));
        if (CollectionUtil.isNotEmpty(tree)) {
            menuList.addAll(tree);
        }
        List<Long>  ids= menuList.stream().map(DeptTree::getId).collect(Collectors.toList());
        this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public SysDept selectByAdmin(Long treeParentId, Long id) {
        return   this.baseMapper.selectByAdmin(treeParentId,id);
    }


    /**
     * 递归整理菜单
     */
    List<DeptTree> recursionTreeApply(List<DeptTree> list, List<Long> parentIds){
        List<DeptTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(DeptTree::getId).collect(Collectors.toList());
        List<DeptTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<DeptTree> tree = this.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<DeptTree> childVos =tree.stream().filter(x->item.getId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };

    /**
     * 递归整理子菜单
     */
    List<DeptTree> recursionChildsListApply(List<DeptTree> list, List<Long> parentIds){
        List<DeptTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(DeptTree::getId).collect(Collectors.toList());
        List<DeptTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        List<DeptTree> tree = this.recursionChildsListApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.addAll(tree);
        return parentVos;
    };
    /**
     * 递归以子集返回菜单树集合
     */
    List<DeptTree> recursionChildsTreeApply(List<DeptTree> list, List<Long> parentIds){
        List<DeptTree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(DeptTree::getId).collect(Collectors.toList());
        List<DeptTree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<DeptTree> tree = this.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<DeptTree> childVos =list.stream().filter(x->item.getId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };

}
