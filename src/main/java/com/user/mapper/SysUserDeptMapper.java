package com.user.mapper;

import com.user.domain.SysUserDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.resp.DeptTree;
import com.user.dto.resp.DeptVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysUserDeptMapper extends BaseMapper<SysUserDept> {

    List<DeptTree> getListByUserId(@Param("userIds") List<Long> userIds);
}
