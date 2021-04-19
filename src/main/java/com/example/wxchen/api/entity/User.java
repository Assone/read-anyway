package com.example.wxchen.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 2021/4/7 16:41
 * 作者:wxchen
 * 描述:用户实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel("用户实体")
public class User implements Serializable {
    @TableId(value = "user_id",type = IdType.AUTO)
    @ApiModelProperty("用户ID 区分不同用户的唯一标识")
    private Long userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("密码")
    private Long password;

    @ApiModelProperty("账号（手机号）")
    private String account;

    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("创建人id")
    private Long creatorId;

    @ApiModelProperty("最近一次更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date latestUpdateTime;

    @ApiModelProperty("最近一次更新人id")
    private Long latestUpdateId;

    @ApiModelProperty("账户类型 0用户 1管理员")
    private Long userType;

}
