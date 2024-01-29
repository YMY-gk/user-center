package com.user.dto.req;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.user.dto.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictTypeReq extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 备注
     */
    private String remark;


}
