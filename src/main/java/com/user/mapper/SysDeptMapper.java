package com.user.mapper;

import com.user.domain.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.resp.DeptTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    List<DeptTree> getDepts(@Param("realmId") Long realmId);

    DeptTree getDeptById(@Param("id") Long id,@Param("realmId") Long realmId);

    List<DeptTree> getDeptByParentId(@Param("realmId")Long realmId);

    SysDept selectByAdmin(@Param("parentId") Long parentId, @Param("realmId") Long realmId);
}
