package com.user.service.oauth.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.domain.OauthClientToken;
import com.user.mapper.OauthClientTokenMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class OauthClientTokenService extends ServiceImpl<OauthClientTokenMapper, OauthClientToken> implements IService<OauthClientToken> {

}
