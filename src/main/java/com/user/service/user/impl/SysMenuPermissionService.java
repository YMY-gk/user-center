package com.user.service.user.impl;

import com.user.domain.SysMenuPermission;
import com.user.dto.req.MenuReq;
import com.user.dto.resp.PermissionVo;
import com.user.mapper.SysMenuPermissionMapper;
import com.user.service.user.ISysMenuPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<PermissionVo> getRolePermissions(MenuReq req) {
        return null;
    }

    @Override
    public void operateRolePermission(MenuReq req) {

    }
}
