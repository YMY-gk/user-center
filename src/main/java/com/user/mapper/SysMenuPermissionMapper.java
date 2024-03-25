package com.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysMenuPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.MenuReq;
import com.user.dto.req.PermissionReq;
import com.user.dto.resp.PermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单-接口关联表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
public interface SysMenuPermissionMapper extends BaseMapper<SysMenuPermission> {

    Page<PermissionVo> getRolePermissions(Page<PermissionVo> page, @Param("req") PermissionReq req);
    List<PermissionVo> getRolePermissions(@Param("req") PermissionReq req);

    List<PermissionVo> getmenuIdPermissions(@Param("req") MenuReq req);
}
