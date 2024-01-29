package com.user.service.user;

import com.user.domain.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.MenuVo;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    List<MenuVo> getRoleMenus(RoleReq req);

    void operateRoleMenu(RoleReq req);
}
