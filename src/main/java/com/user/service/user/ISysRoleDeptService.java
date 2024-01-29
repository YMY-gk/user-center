package com.user.service.user;

import com.user.domain.SysRoleDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.RoleVo;

import java.util.List;

/**
 * <p>
 * 角色和部门关联表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysRoleDeptService extends IService<SysRoleDept> {

    void operateRoleDept(RoleReq req);

    List<RoleVo> getRoleDepts(RoleReq req);
}
