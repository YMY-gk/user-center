package com.user.service.impl;

import com.user.domain.SysUserDept;
import com.user.mapper.SysUserDeptMapper;
import com.user.service.ISysUserDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-22
 */
@Service
public class SysUserDeptService extends ServiceImpl<SysUserDeptMapper, SysUserDept> implements ISysUserDeptService {

}
