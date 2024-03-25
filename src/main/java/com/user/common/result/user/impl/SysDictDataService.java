package com.user.common.result.user.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.common.CommonConest;
import com.user.common.result.user.ISysDictDataService;
import com.user.config.bean.LoginSession;
import com.user.domain.SysDictData;
import com.user.dto.req.DictDataReq;
import com.user.dto.resp.DictDataVo;
import com.user.mapper.SysDictDataMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2024-01-22
 */
@Service
public class SysDictDataService extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {

    @Override
    public Page<DictDataVo> getPageDicts(DictDataReq req) {
        Page<DictDataVo> page = new Page<>(req.getPageIndex(),req.getPageSize());
        Page<DictDataVo> sysDictTypePage = this.baseMapper.getPageDicts(page,req);
        return sysDictTypePage;
    }

    @Override
    public SysDictData getDictTypeById(Long id) {
        SysDictData sysDictData = this.baseMapper.selectById(id);
        return sysDictData;
    }

    @Override
    public void addDictType(SysDictData dictData) {
        this.baseMapper.insert(dictData);
    }

    @Override
    public void delDictType(List<Long> ids) {
        this.baseMapper.deleteIds(ids,LoginSession.getUserName(),System.currentTimeMillis());
    }

    @Override
    public void editDictType(SysDictData dictData) {
        this.baseMapper.updateById(dictData);
    }

    @Override
    public List<SysDictData> listDictData(DictDataReq req) {
        req.setRealmId(LoginSession.getRealm());
        List<SysDictData> list= this.baseMapper.listDictData(req);
        if (CollUtil.isEmpty(list)){
            req.setRealmId(CommonConest.base_realm);
            list= this.baseMapper.listDictData(req);
        }
        return list;
    }

    @Override
    public void delDictTypeByTypes(List<String> types) {
        LambdaQueryWrapper<SysDictData> queryWrapper = new LambdaQueryWrapper<SysDictData>().in(SysDictData::getDictType,types);
        List<SysDictData> sysDictDatas = this.baseMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(sysDictDatas)){
            return;
        }
        this.baseMapper.deleteIds(sysDictDatas.stream().map(SysDictData::getId).collect(Collectors.toList()),LoginSession.getUserName(),System.currentTimeMillis());

    }

    @Override
    public List<SysDictData> getDictDataByType(String type) {
        List<SysDictData> list= this.baseMapper.getDictDataByType(type,LoginSession.getRealm());
        if (CollUtil.isEmpty(list)){
            list= this.baseMapper.getDictDataByType(type,CommonConest.base_realm);
        }
        return list;
    }
}
