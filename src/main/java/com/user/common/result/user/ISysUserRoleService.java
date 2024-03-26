package com.user.common.result.user;

import com.user.domain.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.resp.RoleVo;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    void edit(List<Long> roleIds, Long userId);

    List<RoleVo> getListByUserId(List<Long> userId);
}
