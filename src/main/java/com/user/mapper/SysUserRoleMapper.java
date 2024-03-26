package com.user.mapper;

import com.user.domain.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.resp.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    List<RoleVo> getListByUserId(@Param("userIds") List<Long> userIds);
}
