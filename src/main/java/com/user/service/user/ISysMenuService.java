package com.user.service.user;

import com.user.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.MenuReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<MenuTree> getMenus(MenuReq req);

    MenuVo getMenuById(Long menuId);

    void delMenuId(Long menuId);
    List<MenuTree> getMenuByParentId(Long menuId);
}
