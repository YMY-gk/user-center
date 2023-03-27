package com.user.service.user.impl;

import com.user.domain.SysDept;
import com.user.mapper.SysDeptMapper;
import com.user.service.user.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysDeptService extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

}
