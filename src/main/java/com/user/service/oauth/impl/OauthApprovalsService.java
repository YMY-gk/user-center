package com.user.service.oauth.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.domain.OauthApprovals;
import com.user.mapper.OauthApprovalsMapper;
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
public class OauthApprovalsService extends ServiceImpl<OauthApprovalsMapper, OauthApprovals> implements IService<OauthApprovals> {

}
