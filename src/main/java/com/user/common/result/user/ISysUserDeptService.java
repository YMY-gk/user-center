package com.user.common.result.user;

import com.user.domain.SysUserDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.resp.DeptTree;
import com.user.dto.resp.DeptVo;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysUserDeptService extends IService<SysUserDept> {

    void edit(List<Long> deptIds, Long userId);

    List<DeptTree> getListByUserId(List<Long> userId);
}
