package com.user.util.base;

import com.user.common.CommonCode;
import com.user.common.result.Result;
import com.user.common.result.ResultCode;

/**
 * 描述
 *
 * @author 三国的包子
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
public class ResultUtil<R>  {
    public static <R> Result<R> OK() {
        return OK(null);
    }

    public static <R> Result<R> OK(R data) {
        return OK(data, (Object)null);
    }

    public static <R> Result<R> OK(R data, Object extra) {
        return result(CommonCode.SUCCESS, data, extra, (String)null);
    }

    public static <R> Result<R> OK(R data, Object extra, String status) {
        return result(CommonCode.SUCCESS, data, extra, status);
    }

    public static <R> Result<R> ERROR(ResultCode resultCode) {
        return ERROR(resultCode, null, (Object)null);
    }

    public static <R> Result<R> ERROR(ResultCode resultCode, R data) {
        return ERROR(resultCode, data, (Object)null);
    }

    public static <R> Result<R> ERROR(ResultCode resultCode, R data, Object extra) {
        return result(resultCode, data, extra, (String)null);
    }

    public static <R> Result<R> ERROR(Integer code, R data, String msg) {
        Result<R> resultObject = new Result();
        resultObject.setMsg(msg);
        resultObject.setCode(code);
        resultObject.setData(data);
        return resultObject;
    }
    private static <R> Result<R> result(ResultCode resultCode, R data, Object extra, String status) {
        Result<R> resultObject = new Result(resultCode);
        resultObject.setData(data);
        resultObject.setStatus(status);
        resultObject.setExtra(extra);
        return resultObject;
    }


}
