package com.user.service.user;

import com.user.domain.SysCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 企业表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
 */
public interface ISysCompanyService extends IService<SysCompany> {
    public void inset(SysCompany sysCompany) ;

    void dels(List<Long> ids);
}
