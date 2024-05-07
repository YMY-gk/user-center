package com.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.DictTypeReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-21
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    Page<SysDictType> getPageDictType(IPage<SysDictType> page, @Param("req") DictTypeReq req);

    List<SysDictType> getListDictType(@Param("req") DictTypeReq req);

    void deleteIds(@Param("ids") List<Long> ids, @Param("updateBy") String updateby, @Param("time") long currentTimeMillis);

    List<SysDictType> getDictTypeByDictType(@Param("dictType")  String dictType,@Param("id")   Long id);
}
