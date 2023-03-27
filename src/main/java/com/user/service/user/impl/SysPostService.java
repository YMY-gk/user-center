package com.user.service.user.impl;

import com.user.domain.SysPost;
import com.user.mapper.SysPostMapper;
import com.user.service.user.ISysPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysPostService extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

}
