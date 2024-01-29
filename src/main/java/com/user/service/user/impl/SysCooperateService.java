package com.user.service.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysCooperate;
import com.user.dto.req.CooperateReq;
import com.user.dto.resp.CooperateVo;
import com.user.mapper.SysCooperateMapper;
import com.user.service.user.ISysCooperateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 企业表 服务实现类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
 */
@Service
public class SysCooperateService extends ServiceImpl<SysCooperateMapper, SysCooperate> implements ISysCooperateService {

    @Override
    public void dels(List<Long> ids) {
        this.removeByIds(ids);
    }

    @Override
    public List<CooperateVo> searchcooperate(CooperateReq req) {
        return this.baseMapper.searchcooperate(req);
    }

    @Override
    public void savecooperate(SysCooperate syscooperate) {
        this.baseMapper.insert(syscooperate);
    }

    @Override
    public void editcooperate(SysCooperate syscooperate) {
        this.baseMapper.updateById(syscooperate);
    }

    @Override
    public Page<CooperateVo> searchPagecooperate(CooperateReq req) {
        IPage<CooperateVo> page = new Page<>(req.getPageIndex(),req.getPageSize());
        return this.baseMapper.searchcooperate(page,req);
    }
}
