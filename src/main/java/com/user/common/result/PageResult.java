package com.user.common.result;

import com.user.common.Extra;
import lombok.Data;

import java.util.Collection;

/**
 * 分页结果类
 */
@Data
public class PageResult<R> {
    private static final long serialVersionUID = 4871119395037177159L;


    public PageResult(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Collection<R> data;

    /**
     * 分页额外数据
     */
    private Extra extra;

}
