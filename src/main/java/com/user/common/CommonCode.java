package com.user.common;

import com.user.common.result.ResultCode;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author bin.zhang
 * <p/>
 * Revision History:
 * 2021/05/10, 初始化版本
 * @version 1.0
 **/
@Getter
public enum CommonCode implements ResultCode {

    SUCCESS(0, "成功"),
    LOGIN_ERROR(202, "用户名密码错误！"),
    PARAM(203, "参数错误"),
    TIME_PARAM(204, "时间参数错误"),
    ID_PARAM(205, "主键id不能为空"),
    RECORD_NO_EXIST(206, "操作记录不存在"),

    RESOURCE_HAS_USED(207, "资源已被使用，不能删除"),
    OPERATE_FAIL(208, "当前不支持该操作"),

    PARAM_MISS_ERROR(400, "参数缺失或ContentType错误"),
    PARAM_TYPE_COVER_ERROR(401, "参数类型转化错误"),
    PERMISSION_NO_ERROR(403, "权限不足！"),

    REQUEST_METHOD_ERROR(405, "Method Not Allowed"),
    ;
    private final Integer code;
    private final String msg;

    CommonCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
