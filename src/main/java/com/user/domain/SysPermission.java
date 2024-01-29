package com.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 接口名称
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 接口名称
     */
    @TableField("name")
    private String name;

    /**
     * 请求类型
     */
    @TableField("type")
    private String type;

    /**
     * 请求地址
     */
    @TableField("url")
    private String url;

    /**
     * 请求参数
     */
    @TableField("parms")
    private String parms;

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
     * 备注
     */
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
