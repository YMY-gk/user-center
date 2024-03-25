package com.user.common.result.user.impl;

import com.user.domain.SysNotice;
import com.user.mapper.SysNoticeMapper;
import com.user.common.result.user.ISysNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysNoticeService extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {

}
