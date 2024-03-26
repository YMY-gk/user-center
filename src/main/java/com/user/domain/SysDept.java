package com.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.user.common.CommonConest;
import com.user.config.bean.LoginSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dept")
public class SysDept extends Model<SysDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;

    /**
     * 父部门id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;

    /**
     * 显示顺序
     */
    @TableField("order_num")
    private Integer orderNum;
    /*
     * 负责人
     */
    @TableField("leader")
    private String leader;
    /**
     * 创建者
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value ="create_time",fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新者
     */
    @TableField(value ="update_by",fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value ="update_time",fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;


    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public void initAdmin(Long realmId,String deptName) {
        this.setRealmId(realmId)
                .setDeptName(deptName)
                .setCreateBy( LoginSession.getUserName())
                .setLeader( LoginSession.getUserName())
                .setParentId(CommonConest.treeParentId)
                .setOrderNum(0)
                .setCreateTime(System.currentTimeMillis());
    }
}
