package com.user.dto.resp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class PermissionVo {


    /**
     *
     */
    private Long id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 请求类型
     */
    private String type;

    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求参数
     */
    private String parms;
    /**
     * 备注
     */
    private String remark;
}
