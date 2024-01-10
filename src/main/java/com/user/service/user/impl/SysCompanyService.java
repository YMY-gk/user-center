package com.user.service.user.impl;

import com.user.domain.SysCompany;
import com.user.mapper.SysCompanyMapper;
import com.user.service.user.ISysCompanyService;
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
public class SysCompanyService extends ServiceImpl<SysCompanyMapper, SysCompany> implements ISysCompanyService {

    public void inset(SysCompany sysCompany) {
        this.save(sysCompany);
    }

    @Override
    public void dels(List<Long> ids) {
        this.removeByIds(ids);
    }
}
