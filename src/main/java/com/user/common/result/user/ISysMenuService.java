package com.user.common.result.user;

import com.user.common.result.Result;
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

    List<MenuTree> getMenus();

    MenuVo getMenuById(Long id);

    void delid(Long id);
    List<MenuTree> getMenuByParentId(Long id);

    List<MenuTree> getRoleMenus(Long realmId);

    Result<List<MenuTree>> getRoleMenusByUser();

    void addMenu(SysMenu menu);

    void editMenu(SysMenu menu);

    List<MenuTree> getInitMenus(Long roleId);
}
