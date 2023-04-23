package com.user.dto.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author guokui
 * @class BaseParam
 * @date 2021/5/10 11:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseParam {


    /**
     * 起始页
     */
    @TableField(exist = false)
    private int pageIndex = 0;

    /**
     * 页大小
     */
    @TableField(exist = false)
    private int pageSize = 15;

    /**
     * 开始时间
     */
    @TableField(exist = false)
    private Long startTime;

    /**
     * 结束时间
     */
    @TableField(exist = false)
    private Long endTime;

    public int getPageIndex() {
        return this.pageIndex + 1;
    }

    /**
     * 校验时间区间是否超过日期
     * @param days
     * @return
     */
    public boolean validTimeFrame(Integer days){
        if(null!=this.startTime&&null!=this.endTime){
            Long partTime=this.endTime-this.startTime;
            if(partTime.compareTo(days*86400000L)>0){
                return false;
            }
        }
        return true;
    }
}
