package com.user.service.oauth.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.domain.OauthClientDetails;
import com.user.mapper.OauthClientDetailsMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储客户端的配置信息 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class OauthClientDetailsService extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements IService<OauthClientDetails> {

    public OauthClientDetails selectByClientId(String clientId) {
       return this.baseMapper.selectByClientId(clientId);
    }
}
