package com.user.common.result.user;

import com.user.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.RoleVo;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysRoleService extends IService<SysRole> {

    List<RoleVo> getRoles(RoleReq req);

    void dels(List<Long> ids);

    void saveOrEdit(SysRole role);
}
