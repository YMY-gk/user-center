package com.user.common.result;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.user.util.PageResultUtil;
import com.user.util.ResultUtil;

/**
 * <p></p>
 *
 * @author bin.zhang
 * <p/>
 * Revision History:
 * 2021/05/10, 初始化版本
 * @version 1.0
 **/
public interface ResultCode {

	Integer getCode();

	String getMsg();


	default <R> Result<R> covert(){
		return ResultUtil.ERROR(this);
	}
	default <R> PageResult<Object> covertP(){
		return PageResultUtil.ERROR(this,new Page<Object>());
	}
}
