package com.sly.swagger.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author slystart
 * @date 2022/7/13 - 15:34
 */
//实体类注释
@Api("注释")
@ApiModel("用户实体类")
@Data
public class User {
    @ApiModelProperty("用户名")
    public  String  username;
    @ApiModelProperty("用户密码")
    public  String  password;
}
