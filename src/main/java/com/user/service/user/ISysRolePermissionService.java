package com.user.service.user;

import com.user.domain.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.PermissionVo;

import java.util.List;

/**
 * <p>
 * 角色和权限关联表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {

    void operateRolePermission(RoleReq req);

    List<PermissionVo> getRolePermissions(RoleReq req);
}
