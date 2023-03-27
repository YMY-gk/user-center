package com.user.service.oauth.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.domain.OauthCode;
import com.user.mapper.OauthCodeMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储服务端系统生成的授权码code的值 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class OauthCodeService extends ServiceImpl<OauthCodeMapper, OauthCode> implements IService<OauthCode> {

}
