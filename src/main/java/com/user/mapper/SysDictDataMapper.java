package com.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.DictDataReq;
import com.user.dto.resp.DictDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-22
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    Page<DictDataVo> getPageDicts(Page<DictDataVo> page, @Param("req") DictDataReq req);

    List<SysDictData> listDictData(@Param("req") DictDataReq req);

    void deleteIds(@Param("ids") List<Long> ids, @Param("updateBy") String updateby, @Param("time") long currentTimeMillis);


    List<SysDictData> getDictDataByType(@Param("type") String type, @Param("realmId") Integer realmId);
}
