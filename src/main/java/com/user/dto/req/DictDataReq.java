package com.user.dto.req;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.user.dto.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictDataReq extends BaseParam {

    private static final long serialVersionUID = 1L;

    private List<Long> ids;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 备注
     */
    private Integer isDefault;



}
