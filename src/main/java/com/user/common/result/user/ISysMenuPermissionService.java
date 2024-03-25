package com.user.common.result.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysMenuPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.MenuReq;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;

import java.util.List;

/**
 * <p>
 * 菜单-接口关联表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
public interface ISysMenuPermissionService extends IService<SysMenuPermission> {

    Page<PermissionVo> getRolePermissions(PermissionReq req);

    void operateRolePermission(MenuReq req);
    List<PermissionVo> listRolePermissions(PermissionReq req);

    void delPermission(MenuReq req);
}
