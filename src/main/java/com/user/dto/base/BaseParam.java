package com.user.dto.base;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("基础请求参数")
public class BaseParam {


    /**
     * 起始页
     */
    @ApiModelProperty("起始页")
    private int pageIndex = 0;

    /**
     * 页大小
     */
    @ApiModelProperty("页大小")
    private int pageSize = 15;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Long startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Long endTime;
    /**
     * 公司id
     */
    @ApiModelProperty("合作方id")
    private Long realmId;

    public int getPageIndex() {
        return this.pageIndex + 1;
    }

}
