package com.user.common.result.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.Result;
import com.user.domain.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.DictTypeReq;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-21
 */
public interface ISysDictTypeService extends IService<SysDictType> {

    Page<SysDictType> getPageDictType(DictTypeReq req);

    SysDictType getDictTypeById(Long id);

    Result<Object> addDictType(SysDictType dictType);

    Result<Object> editDictType(SysDictType dictType);

    void delDictType(List<Long> id);

    List<SysDictType> getListDictType(DictTypeReq req);
}
