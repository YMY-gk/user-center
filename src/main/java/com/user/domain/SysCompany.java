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
 * 企业表
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
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
     * 机构唯一编码
     */
    @TableField("realm")
    private String realm;

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
    @TableField("company_area")
    private String companyArea;

    /**
     * 公司地址
     */
    @TableField("company_address")
    private String companyAddress;

    /**
     * 营业执照-图片
     */
    @TableField("business_license")
    private String businessLicense;

    /**
     * 公司电话
     */
    @TableField("company_phone")
    private String companyPhone;

    /**
     * 邮箱
     */
    @TableField("mailbox")
    private String mailbox;

    /**
     * 公司规模
     */
    @TableField("company_size")
    private Double companySize;

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
    @TableField("state")
    private Integer state;

    /**
     * 当前余额
     */
    @TableField("balance")
    private String balance;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 对接人
     */
    @TableField("contactor")
    private String contactor;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
