package com.user.common.result.user;

import com.user.domain.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.DeptReq;
import com.user.dto.resp.DeptTree;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysDeptService extends IService<SysDept> {

    List<DeptTree> getDepts(DeptReq req);

    DeptTree getDeptById(Long id);

    List<DeptTree> getDeptByParentId(Long id, Long realmId);

    void delDeptId(Long menuId, Long realmId);

    SysDept selectByAdmin(Long treeParentId, Long id);

    List<DeptTree> getDeptLists(DeptReq req);
}
