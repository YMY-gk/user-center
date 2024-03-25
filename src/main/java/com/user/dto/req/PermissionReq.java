package com.user.dto.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 菜单权限表
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PermissionReq extends BaseParam {


    /**
     * 接口名称
     */
    private String name;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 菜单类型
     */
    private String type;
    /**
     * 控制接口是否返回勾选
     */
    private Boolean flag = false;
    /**
     * 接口ids
     */
    private List<Long> ids;
}
