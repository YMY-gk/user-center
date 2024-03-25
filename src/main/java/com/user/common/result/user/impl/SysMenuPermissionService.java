package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.user.ISysMenuPermissionService;
import com.user.domain.SysMenuPermission;
import com.user.dto.req.MenuReq;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;
import com.user.mapper.SysMenuPermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单-接口关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
@Service
public class SysMenuPermissionService extends ServiceImpl<SysMenuPermissionMapper, SysMenuPermission> implements ISysMenuPermissionService {


    @Override
    public Page<PermissionVo> getRolePermissions(PermissionReq req) {
        Page<PermissionVo> page = new Page<>(req.getPageIndex(),req.getPageSize());
        return this.baseMapper.getRolePermissions(page,req);
    }

    @Override
    public void operateRolePermission(MenuReq req) {
        List<SysMenuPermission> sysMenuPermissions = new ArrayList<>();
        if (req.getId()!=null&&req.getPermissionIds().size()>0){
            Map<Long,Long> map =  this.baseMapper.getmenuIdPermissions(req)
                    .stream().distinct().collect(Collectors.toMap(PermissionVo::getMpId,PermissionVo::getId));

            req.getPermissionIds().stream().distinct().forEach(item->{
                SysMenuPermission permission = new SysMenuPermission();
                permission.setMenuId(req.getId()).setPermissionId(item).setId(map.get(item));
                sysMenuPermissions.add(permission);
            });
        }
        if (CollUtil.isNotEmpty(sysMenuPermissions)) {
            this.saveBatch(sysMenuPermissions);
        }
    }

    @Override
    public List<PermissionVo> listRolePermissions(PermissionReq req) {
        return this.baseMapper.getRolePermissions(req);
    }

    @Override
    public void delPermission(MenuReq req) {
         this.baseMapper.deleteBatchIds(req.getIds());
    }

}
