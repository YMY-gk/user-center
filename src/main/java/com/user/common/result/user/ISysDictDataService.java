package com.user.common.result.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.Result;
import com.user.domain.SysDictData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.DictDataReq;
import com.user.dto.resp.DictDataVo;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-22
 */
public interface ISysDictDataService extends IService<SysDictData> {

    Page<DictDataVo> getPageDicts(DictDataReq req);

    SysDictData getDictTypeById(Long id);

    void addDictType(SysDictData dictType);

    void delDictType(List<Long> ids);

    Result<Object> editDictType(SysDictData dictType);

    List<SysDictData> listDictData(DictDataReq req);

    void delDictTypeByTypes(List<String> types);

    List<SysDictData> getDictDataByType(String type, Long realm);
}
