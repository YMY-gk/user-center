package com.user.service.user;

import com.user.domain.SysMenuPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.MenuReq;
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

    List<PermissionVo> getRolePermissions(MenuReq req);

    void operateRolePermission(MenuReq req);
}
