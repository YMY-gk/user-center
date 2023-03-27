package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 存储用户生成access_token
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oauth_access_token")
public class OauthAccessToken extends Model<OauthAccessToken> {

    private static final long serialVersionUID = 1L;

    @TableField("token_id")
    private String tokenId;

    @TableField("token")
    private String token;

    @TableId("authentication_id")
    private String authenticationId;

    @TableField("user_name")
    private String userName;

    @TableField("client_id")
    private String clientId;

    @TableField("authentication")
    private String authentication;

    @TableField("refresh_token")
    private String refreshToken;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;


    @Override
    protected Serializable pkVal() {
        return this.authenticationId;
    }

}
