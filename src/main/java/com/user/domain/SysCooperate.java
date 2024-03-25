package com.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_cooperate")
public class SysCooperate extends Model<SysCooperate> {

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
     * 续期时间
     */
    @TableField("renewal_date")
    private Long renewalDate;

    /**
     * 到期时间
     */
    @TableField("expiration_date")
    private Long expirationDate;

    /**
     * 公司地区
     */
    @TableField("cooperate_area")
    private String cooperateArea;

    /**
     * 公司地址
     */
    @TableField("cooperate_address")
    private String cooperateAddress;

    /**
     * 营业执照-图片
     */
    @TableField("business_license")
    private String businessLicense;

    /**
     * 公司电话
     */
    @TableField("cooperate_phone")
    private String cooperatePhone;

    /**
     * 邮箱
     */
    @TableField("mailbox")
    private String mailbox;

    /**
     * 公司规模
     */
    @TableField("cooperate_size")
    private Double cooperateSize;

    /**
     * 所属行业
     */
    @TableField("industry")
    private String industry;

    /**
     * 审核状态
     */
    @TableField("audit_state")
    private Integer auditState;

    /**
     * 状态
     */
    @TableField("is_del")
    @TableLogic
    private Integer isDel;

    /**
     * 当前余额
     */
    @TableField("balance")
    private String balance;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 对接人
     */
    @TableField("contactor")
    private String contactor;
    /**
     * 是否合作 0否，1：是
     */
    @TableField("is_cooperate")
    private Integer isCooperate;
    /**
     * 审核备注
     */
    @TableField("audit_remark")
    private String auditRemark;
    /**
     * 合作方介绍
     */
    @TableField("remark")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
