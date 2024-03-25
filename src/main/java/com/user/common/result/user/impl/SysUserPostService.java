package com.user.common.result.user.impl;

import com.user.domain.SysUserPost;
import com.user.mapper.SysUserPostMapper;
import com.user.common.result.user.ISysUserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysUserPostService extends ServiceImpl<SysUserPostMapper, SysUserPost> implements ISysUserPostService {

}
