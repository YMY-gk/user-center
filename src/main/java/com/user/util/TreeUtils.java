package com.user.util;

import cn.hutool.core.collection.CollectionUtil;
import com.user.common.tree.Tree;
import com.user.dto.resp.MenuTree;

import java.util.List;
import java.util.stream.Collectors;

public class TreeUtils {

    /**
     * 递归整理菜单
     */
   public static List<Tree> recursionTreeApply(List<Tree> list, List<Long> parentIds){
        List<Tree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(Tree::getId).collect(Collectors.toList());
        List<Tree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<Tree> tree = TreeUtils.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<Tree> childVos =tree.stream().filter(x->item.getId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };

    /**
     * 递归整理子菜单
     */
    public static List<Tree> recursionChildsListApply(List<Tree> list, List<Long> parentIds){
        List<Tree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(Tree::getId).collect(Collectors.toList());
        List<Tree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        List<Tree> tree = TreeUtils.recursionChildsListApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.addAll(tree);
        return parentVos;
    };
    /**
     * 递归以子集返回菜单树集合
     */
    public static List<Tree> recursionChildsTreeApply(List<Tree> list, List<Long> parentIds){
        List<Tree> parentVos =list.stream().filter(x->parentIds.contains(x.getParentId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(parentVos)){
            return null;
        }
        List<Long> ids = parentVos.stream().map(Tree::getId).collect(Collectors.toList());
        List<Tree> residue  =list.stream().filter(x->!ids.contains(x.getId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(residue)){
            return parentVos;
        }
        List<Tree> tree = TreeUtils.recursionTreeApply(residue,ids);
        if (CollectionUtil.isEmpty(tree)){
            return parentVos;
        }
        parentVos.forEach(item->{
            List<Tree> childVos =list.stream().filter(x->item.getId().compareTo(x.getParentId())==0).collect(Collectors.toList());
            item.setChilds(childVos);
        });
        return parentVos;
    };
}
