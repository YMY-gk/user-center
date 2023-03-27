package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 存储服务端系统生成的授权码code的值
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oauth_code")
public class OauthCode extends Model<OauthCode> {

    private static final long serialVersionUID = 1L;

    @TableField("code")
    private String code;

    @TableField("authentication")
    private String authentication;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
