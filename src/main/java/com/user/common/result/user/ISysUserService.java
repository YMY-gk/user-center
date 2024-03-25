package com.user.common.result.user;

import com.user.common.result.PageResult;
import com.user.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.dto.req.UserReq;
import com.user.dto.resp.UserVo;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author GUOKUI
 * @since 2023-03-26
 */
public interface ISysUserService extends IService<SysUser> {

    PageResult<UserVo> getPage(UserReq user);
    List<UserVo> getList(UserReq user);
}
