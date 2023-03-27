package com.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 存储客户端的配置信息
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oauth_client_details")
public class OauthClientDetails extends Model<OauthClientDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户端ID，主要用于标识对应的应用
     */
    @TableId("client_id")
    private String clientId;

    @TableField("resource_ids")
    private String resourceIds;

    /**
     * 客户端秘钥，BCryptPasswordEncoder加密
     */
    @TableField("client_secret")
    private String clientSecret;

    /**
     * 对应的范围
     */
    @TableField("scope")
    private String scope;

    /**
     * 认证模式
     */
    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * 认证后重定向地址
     */
    @TableField("web_server_redirect_uri")
    private String webServerRedirectUri;

    @TableField("authorities")
    private String authorities;

    /**
     * 令牌有效期
     */
    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 令牌刷新周期
     */
    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;

    @TableField("additional_information")
    private String additionalInformation;

    @TableField("autoapprove")
    private String autoapprove;

    /**
     * 公司id
     */
    @TableField("realm_id")
    private Long realmId;


    @Override
    protected Serializable pkVal() {
        return this.clientId;
    }

}
