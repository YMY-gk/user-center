package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.result.user.ISysDictTypeService;
import com.user.config.bean.LoginSession;
import com.user.domain.SysDictType;
import com.user.dto.req.DictTypeReq;
import com.user.mapper.SysDictTypeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-21
 */
@Service
public class SysDictTypeService extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {

    @Autowired
    SysDictDataService sysDictDataService;
    public Page<SysDictType> getPageDictType(DictTypeReq req) {
        IPage<SysDictType> page = new Page<>(req.getPageIndex(),req.getPageSize());
        Page<SysDictType> result= this.baseMapper.getPageDictType(page,req);
        return result;
    }

    @Override
    public SysDictType getDictTypeById(Long id) {
        SysDictType sysDictType= this.baseMapper.selectById(id);
        return sysDictType;
    }

    @Override
    public void addDictType(SysDictType dictType) {
        this.baseMapper.insert(dictType);
    }

    @Override
    public void editDictType(SysDictType dictType) {
        this.baseMapper.updateById(dictType);
    }

    @Override
    public void delDictType(List<Long> ids) {
        List<SysDictType> sysDictTypes= this.baseMapper.selectBatchIds(ids);
        if (CollUtil.isEmpty(sysDictTypes)){
            return;
        }
        this.baseMapper.deleteIds(ids,LoginSession.getUserName(),System.currentTimeMillis());
        List<String>  types = sysDictTypes.stream().map(SysDictType::getDictType).collect(Collectors.toList());
        sysDictDataService.delDictTypeByTypes(types);
    }

    @Override
    public List<SysDictType> getListDictType(DictTypeReq req) {
        List<SysDictType> list= this.baseMapper.getListDictType(req);
        return list;
    }
}
