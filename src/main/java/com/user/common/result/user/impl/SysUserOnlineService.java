package com.user.common.result.user.impl;

import com.user.common.result.user.ISysUserOnlineService;
import com.user.domain.SysUserOnline;
import com.user.mapper.SysUserOnlineMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 在线用户记录 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysUserOnlineService extends ServiceImpl<SysUserOnlineMapper, SysUserOnline> implements ISysUserOnlineService {

}
