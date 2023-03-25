package com.user.service.impl;

import com.user.domain.SysRoleMenu;
import com.user.mapper.SysRoleMenuMapper;
import com.user.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@Service
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

}
