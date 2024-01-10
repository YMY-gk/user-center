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


    LOGIN_ERROR(201, "用户名密码错误！"),

    PARAM(202, "参数错误"),
    TIME_PARAM(202, "时间参数错误"),
    ID_PARAM(202, "主键id不能为空"),
    RECORD_NO_EXIST(203, "操作记录不存在"),

    SUCCESS(0, "成功"),
    PARAM_MISS_ERROR(400, "参数缺失或ContentType错误"),
    PARAM_TYPE_COVER_ERROR(400, "参数类型转化错误"),

    REQUEST_METHOD_ERROR(405, "Method Not Allowed"),
    RESOURCE_HAS_USED(204, "资源已被使用，不能删除"),

    OPERATE_FAIL(205, "当前不支持该操作"),

    ;
    private final Integer code;
    private final String msg;

    CommonCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
