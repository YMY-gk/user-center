package com.user.mapper;

import com.user.domain.OauthClientDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 存储客户端的配置信息 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {

    OauthClientDetails selectByClientId(@Param("clientId") String clientId);
}
