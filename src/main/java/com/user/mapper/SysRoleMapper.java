package com.user.mapper;

import com.user.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.RoleReq;
import com.user.dto.resp.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<RoleVo> getRoles(@Param("req") RoleReq req);

    SysRole selectByAdmin(@Param("isAdmin") Integer isAdmin,@Param("realmId")  Long realmId);
}
