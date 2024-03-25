package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.user.common.CommonConest;
import com.user.config.bean.LoginSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色权限字符串
     */
    @TableField("role_key")
    private String roleKey;

    /**
     * 显示顺序
     */
    @TableField("role_sort")
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @TableField("data_scope")
    private Integer dataScope;

    /**
     * 角色状态（0；异常 1正常）
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Long updateTime;

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
    /**
     * 是否删除：0未，1删除
     */
    @TableField("is_admin")
    private Integer isAdmin;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    public void initAdmin(String name,Long realmId) {
        this.createBy =LoginSession.getUserName();
        this.isAdmin = CommonConest.base_admin;
        this.remark ="系统管理员角色";
        this.realmId =realmId;
        this.status =0;
        this.roleSort =0;
        this.dataScope =0;
        this.roleKey ="admin";
        this.roleName =name;
    }
}
