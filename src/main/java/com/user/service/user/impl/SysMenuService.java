package com.user.service.user.impl;

import com.user.domain.SysMenu;
import com.user.mapper.SysMenuMapper;
import com.user.service.user.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

}
