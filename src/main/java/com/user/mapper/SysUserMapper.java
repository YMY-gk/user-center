package com.user.mapper;

import com.user.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByName(@Param("username") String username, @Param("realm") Long realm);
}
