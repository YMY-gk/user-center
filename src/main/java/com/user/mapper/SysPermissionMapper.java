package com.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysDictType;
import com.user.domain.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    Page<PermissionVo> pagePermissions(IPage<SysDictType> page,@Param("req") PermissionReq req);

    Page<PermissionVo> getNotMenuPermissions(Page<PermissionVo> page, @Param("req") PermissionReq req);
}
