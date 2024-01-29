package com.user.dto.resp;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class CooperateVo {


    /**
     * 主键
     */
    private Long id;

    /**
     * 公司
     */
    private String name;

    /**
     * 续期时间
     */
    private Long renewalDate;

    /**
     * 到期时间
     */
    private Long expirationDate;

    /**
     * 公司地区
     */
    private String cooperateArea;

    /**
     * 公司地址
     */
    private String cooperateAddress;

    /**
     * 营业执照-图片
     */
    private String businessLicense;

    /**
     * 公司电话
     */
    private String cooperatePhone;

    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * 公司规模
     */
    private Integer cooperateSize;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 审核状态
     */
    private Integer auditState;

    /**
     * 状态
     */
    private Integer isDel;

    /**
     * 当前余额
     */
    private String balance;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 对接人
     */
    private String contactor;
    /**
     * 是否合作 0 否 1是
     */
    private int isCooperate;


}
