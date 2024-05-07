package com.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.UserReq;
import com.user.dto.resp.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByName(@Param("username") String username);
    List<SysUser> selectUsersByName(@Param("username") String username, @Param("id") Long id, @Param("realmId") Long realmId);

    Page<UserVo> queryList(Page<UserVo> page, @Param("user")  UserReq user);
    List<UserVo> queryList(@Param("user")  UserReq user);
}
