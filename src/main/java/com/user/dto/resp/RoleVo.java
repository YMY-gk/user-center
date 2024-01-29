package com.user.dto.resp;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class RoleVo  {

    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String roleKey;
    /**
     * 显示顺序
     */
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private String dataScope;
    /**
     * 角色状态（0正常 1停用）
     */
    private String status;
    /**
     * 机构id
     */
    private Integer realmId;
    /**
     * 备注
     */
    private String remark;
}
