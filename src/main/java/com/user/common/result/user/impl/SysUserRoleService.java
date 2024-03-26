package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.domain.SysUserDept;
import com.user.domain.SysUserRole;
import com.user.dto.resp.RoleVo;
import com.user.mapper.SysUserRoleMapper;
import com.user.common.result.user.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public void edit(List<Long> roleIds, Long userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserRole::getUserId,userId);
        List<SysUserRole> roles= this.baseMapper.selectList(queryWrapper);
        List<Long> dels = roles.stream().filter(x->!roleIds.contains(x.getRoleId())).map(SysUserRole::getId).collect(Collectors.toList());
        Map<Long,SysUserRole> map = roles.stream().filter(x->roleIds.contains(x.getRoleId())).collect(Collectors.toMap(SysUserRole::getRoleId, Function.identity()));

        List<SysUserRole> deptList = new ArrayList<>();
        if (CollUtil.isNotEmpty(dels)) {
            this.removeByIds(dels);
        }
        roleIds.forEach(item->{
            SysUserRole role = map.get(item);
            if (ObjectUtil.isNotEmpty(role)){
                deptList.add(role);
                return;
            }
            role = new SysUserRole();
            role.setUserId(userId).setRoleId(item);
            deptList.add(role);
        });
        this.saveOrUpdateBatch(deptList);
    }

    @Override
    public List<RoleVo> getListByUserId(List<Long> userId) {
        return this.baseMapper.getListByUserId(userId);

    }
}
