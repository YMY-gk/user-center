package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公司表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_company")
public class SysCompany extends Model<SysCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司
     */
    @TableField("name")
    private String name;

    /**
     * 公司唯一标识
     */
    @TableField("realm")
    private String realm;

    /**
     * 是否删除，0-未删除，1-已删除
     */
    @TableField("is_del")
    @TableLogic
    private Integer isDel;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Long updateTime;

    /**
     * 创建人id
     */
    @TableField("creator")
    private Long creator;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
