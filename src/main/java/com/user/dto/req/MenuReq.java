package com.user.dto.req;

import com.user.dto.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuReq extends BaseParam {

    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色IDs
     */
    private List<Long> roleIds;
    /**
     * 菜单
     */
    private List<Long> menuIds;
    /**
     *权限ids
     */
    private List<Long> permissionIds;
}
