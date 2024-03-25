package com.user.common.result.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysCooperate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.base.BaseAuth;
import com.user.dto.req.CooperateReq;
import com.user.dto.resp.CooperateVo;

import java.util.List;

/**
 * <p>
 * 企业表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
 */
public interface ISysCooperateService extends IService<SysCooperate> {

    void dels(List<Long> ids);

    List<CooperateVo> searchcooperate(CooperateReq req);

    void savecooperate(SysCooperate syscooperate);

    void editcooperate(SysCooperate syscooperate);

    Page<CooperateVo> searchPagecooperate(CooperateReq req);

    void authCooperate(BaseAuth baseAuth);
}
