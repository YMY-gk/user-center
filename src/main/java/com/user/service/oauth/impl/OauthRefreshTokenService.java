package com.user.service.oauth.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.domain.OauthRefreshToken;
import com.user.mapper.OauthRefreshTokenMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储刷新令牌的refresh_token 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class OauthRefreshTokenService extends ServiceImpl<OauthRefreshTokenMapper, OauthRefreshToken> implements IService<OauthRefreshToken> {

}
