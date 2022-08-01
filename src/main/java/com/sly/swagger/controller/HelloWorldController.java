package com.sly.swagger.controller;

import com.sly.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slystart
 * @date 2022/7/12 - 15:54
 */
@Api(tags = "数据")
@RestController
public class HelloWorldController {
    @RequestMapping(value = "/hello")
    public String helloWord(){
        return "hello fucking world";
    }

    @PostMapping(value = "/user")
    public User UserTest(){
        return new User();
    }

    //@ApiOperation写在方法上
    @ApiOperation("hello控制类")
    @RequestMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("User控制类")
    @PostMapping("/user2")
    public  User User2(@ApiParam("用户登录信息") User user){
        return user;
    }
}
