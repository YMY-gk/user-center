package com.user.service.oauth.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.domain.OauthAccessToken;
import com.user.mapper.OauthAccessTokenMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储用户生成access_token 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class OauthAccessTokenService extends ServiceImpl<OauthAccessTokenMapper, OauthAccessToken> implements IService<OauthAccessToken> {

}
