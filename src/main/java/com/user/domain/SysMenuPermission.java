package com.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单-接口关联表
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu_permission")
public class SysMenuPermission extends Model<SysMenuPermission> {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Long menuId;

    /**
     * 角色ID
     */
    @TableField("permission_id")
    private Long permissionId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
