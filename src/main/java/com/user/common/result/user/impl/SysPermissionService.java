package com.user.common.result.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysDictType;
import com.user.domain.SysPermission;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;
import com.user.mapper.SysPermissionMapper;
import com.user.common.result.user.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
@Service
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    @Autowired
    SysMenuPermissionService sysMenuPermissionService;
    @Override
    public Page<PermissionVo> pagePermissions(PermissionReq req) {
        IPage<SysDictType> page = new Page<>(req.getPageIndex(),req.getPageSize());
        Page<PermissionVo> result= this.baseMapper.pagePermissions(page,req);
        return result;
    }

    @Override
    public Page<PermissionVo> getNotMenuPermissions(PermissionReq req) {
        List<Long> ids = new ArrayList<>();
        if (req.getFlag()) {
            List<PermissionVo> list = sysMenuPermissionService.listRolePermissions(req);
            ids.addAll(list.stream().map(PermissionVo::getId).distinct().collect(Collectors.toList()));
            req.setIds(ids);
        }
        Page<PermissionVo> page = new Page<>(req.getPageIndex(),req.getPageSize());
        Page<PermissionVo> result= this.baseMapper.getNotMenuPermissions(page,req);
        result.getRecords().forEach(item->{
            if (ids.contains(item.getId())){
                item.setIsSelect(true);
            }else{
                item.setIsSelect(false);
            }
        });
        return result;
    }

}
