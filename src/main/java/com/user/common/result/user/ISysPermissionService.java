package com.user.common.result.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
public interface ISysPermissionService extends IService<SysPermission> {

    Page<PermissionVo> pagePermissions(PermissionReq req);

    Page<PermissionVo> getNotMenuPermissions(PermissionReq req);
}
