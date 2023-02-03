package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-02-03
 */
@Getter
@Setter
@TableName("jimu_dict")
@ApiModel(value = "JimuDict对象", description = "")
public class JimuDict implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty("字典名称")
    private String dictName;

    @ApiModelProperty("字典编码")
    private String dictCode;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("删除状态")
    private Integer delFlag;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("字典类型0为string,1为number")
    private Integer type;

    @ApiModelProperty("多租户标识")
    private String tenantId;
}
