package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 显示顺序
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 请求地址
     */
    @TableField("url")
    private String url;

    /**
     * 打开方式（menuItem页签 menuBlank新窗口）
     */
    @TableField("target")
    private String target;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @TableField("menu_type")
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    @TableField("visible")
    private String visible;

    /**
     * 权限标识
     */
    @TableField("perms")
    private String perms;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否删除：0未，1删除
     */
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
