package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.user.domain.SysUserDept;
import com.user.dto.resp.DeptTree;
import com.user.dto.resp.DeptVo;
import com.user.mapper.SysUserDeptMapper;
import com.user.common.result.user.ISysUserDeptService;
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
public class SysUserDeptService extends ServiceImpl<SysUserDeptMapper, SysUserDept> implements ISysUserDeptService {

    @Override
    public void edit(List<Long> deptIds, Long userId) {
        QueryWrapper<SysUserDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserDept::getUserId,userId);
        List<SysUserDept> depts= this.baseMapper.selectList(queryWrapper);
        List<Long> dels = depts.stream().filter(x->!deptIds.contains(x.getDeptId())).map(SysUserDept::getId).collect(Collectors.toList());
        Map<Long,SysUserDept> map = depts.stream().filter(x->deptIds.contains(x.getDeptId())).collect(Collectors.toMap(SysUserDept::getDeptId, Function.identity()));

        List<SysUserDept> deptList = new ArrayList<>();
        if (CollUtil.isNotEmpty(dels)) {
            this.removeByIds(dels);
        }
        deptIds.forEach(item->{
            SysUserDept dept = map.get(item);
            if (ObjectUtil.isNotEmpty(dept)){
                deptList.add(dept);
                return;
            }
            dept = new SysUserDept();
            dept.setUserId(userId).setDeptId(item);
            deptList.add(dept);
        });
        this.saveOrUpdateBatch(deptList);
    }

    @Override
    public List<DeptTree> getListByUserId(List<Long> userIds) {
        return this.baseMapper.getListByUserId(userIds);
    }
}
