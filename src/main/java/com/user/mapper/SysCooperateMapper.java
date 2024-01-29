package com.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.domain.SysCooperate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.dto.req.CooperateReq;
import com.user.dto.resp.CooperateVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 企业表 Mapper 接口
 * </p>
 *
 * @author GUOKUI
 * @since 2023-09-25
 */
public interface SysCooperateMapper extends BaseMapper<SysCooperate> {

    List<CooperateVo> searchcooperate(@Param("req") CooperateReq req);
    Page<CooperateVo> searchcooperate(IPage<CooperateVo> page, @Param("req") CooperateReq req);

}
