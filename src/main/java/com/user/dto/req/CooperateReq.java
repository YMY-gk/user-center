package com.user.dto.req;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.user.dto.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
public class CooperateReq  extends BaseParam {


    /**
     * 主键
     */
    private Long id;

    /**
     * 主键
     */
    private List<Long> ids;

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



}
