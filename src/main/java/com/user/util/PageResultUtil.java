package com.user.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.user.common.CommonCode;
import com.user.common.Extra;
import com.user.common.result.PageResult;
import com.user.common.result.ResultCode;

import java.util.Collection;

/**
 * 描述
 *
 * @author 三国的包子
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
public class PageResultUtil<T>  {
    /**
     * 正常返回数据
     * @param page
     * @param <R>
     * @return
     */
    public static <R> PageResult<R> OK(IPage<R> page){
        return pageResult(CommonCode.SUCCESS, page.getRecords(), buildExtra(page));
    }


    /**
     * 添加额外数据的正常返回
     * @param page
     * @param object
     * @param <R>
     * @return
     */
    public static <R> PageResult<R> OK(IPage<R> page, Object object){
        return pageResult(CommonCode.SUCCESS, page.getRecords(), buildExtra(page,object));
    }

    /**
     *
     * @param page
     * @param object
     * @param <R>
     * @return
     */
    private static <R> Extra buildExtra(IPage<R> page, Object object) {
        long more = page.getTotal() - page.getSize() * page.getCurrent();
        Extra extra = new Extra();
        extra.setTotal(page.getTotal());
        extra.setPageIndex(page.getCurrent());
        extra.setPageSize(page.getSize());
        extra.setMore(more < 0 ? 0 : more);
        extra.setObject(object);
        return extra;
    }


    /**
     * 错误返回
     * @param <R>
     * @return
     */
    public static <R> PageResult<R> ERROR(ResultCode resultCode, IPage<R> page){
        return pageResult(resultCode, page.getRecords(), buildExtra(page));
    }

    public static <R> PageResult<R> ERROR(ResultCode resultCode){
        return pageResult(resultCode,null, null);
    }


    /**
     *
     * @param resultCode
     * @param data
     * @param extra
     * @param <R>
     * @return
     */
    private static <R> PageResult<R> pageResult(ResultCode resultCode, Collection<R> data, Extra extra){
        PageResult<R> pageResultObject = new PageResult<>(resultCode);
        pageResultObject.setData(data);
        pageResultObject.setExtra(extra);
        return pageResultObject;
    }


    /**
     *
     * @param page
     * @return
     */
    private static Extra buildExtra(IPage<?> page){
        long more = page.getTotal() - page.getSize() * page.getCurrent();
        Extra extra = new Extra();
        extra.setTotal(page.getTotal());
        extra.setPageIndex(page.getCurrent());
        extra.setPageSize(page.getSize());
        extra.setMore(more < 0 ? 0 : more);
        return extra;
    }


    private PageResultUtil(){}

}
