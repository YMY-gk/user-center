package com.user.dto.base;

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
@ApiModel("基础审核参数")
public class BaseAuth {

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private int status ;
    /**
     * 备注
     */
    @ApiModelProperty("状态")
    private String auditRemark;

    /**
     * 公司id
     */
    @ApiModelProperty("主键id")
    private Long id;


}
