package com.user.common.result.user.impl;

import com.user.domain.SysRoleMenu;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.MenuVo;
import com.user.mapper.SysRoleMenuMapper;
import com.user.common.result.user.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    @Override
    public List<MenuVo> getRoleMenus(RoleReq req) {
        return null;
    }

    @Override
    public void operateRoleMenu(RoleReq req) {

    }
}
