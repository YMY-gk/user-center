package com.user.service.user.impl;

import com.user.domain.SysRoleDept;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.RoleVo;
import com.user.mapper.SysRoleDeptMapper;
import com.user.service.user.ISysRoleDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysRoleDeptService extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements ISysRoleDeptService {

    @Override
    public void operateRoleDept(RoleReq req) {

    }

    @Override
    public List<RoleVo> getRoleDepts(RoleReq req) {
        return null;
    }
}
