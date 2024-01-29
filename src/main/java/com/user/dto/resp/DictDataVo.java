package com.user.dto.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class DictDataVo  {

    /**
     * id
     */
    private Long id;
    /**
     * 字典排序
     */
    private Integer dictSort;

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
    private String dictTypeName;
    private String dictType;

    /**
     * 是否默认（Y是 N否）
     */
    private Integer isDefault;

    /**
     * 备注
     */
    private String remark;

    /**
     * 合作Id 
     */
    private Long realmId;

    /**
     * 合作名
     */
    private String realmName;

}
