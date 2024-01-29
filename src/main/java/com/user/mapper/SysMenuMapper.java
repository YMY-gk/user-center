package com.user.mapper;

import com.user.domain.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.MenuReq;
import com.user.dto.resp.MenuTree;
import com.user.dto.resp.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<MenuTree> getMenus();

    MenuVo getMenuById(@Param("menuId") Long menuId);

    List<MenuVo> getMenuByParentId(@Param("menuId")Long menuId);
}
