package com.iblog.controller;

import com.iblog.entity.User;
import com.iblog.service.IUserService;
import com.iblog.service.impl.UserServiceImpl;
import com.iblog.util.AuthResponse;
import com.iblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//处理用户相关请求的控制器类
@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("register")
    public JsonResult<Void> reg(User user){
        //调用业务对象执行注册
        userService.reg(user);
        //返回
        return new JsonResult<>(JsonResult.SUCCESS_CODE);
    }

    @RequestMapping("login")
    public JsonResult<AuthResponse> login(String username,String password){
        //调用业务对象执行登录
        String token = userService.login(username, password);
        return new JsonResult<>(JsonResult.SUCCESS_CODE, new AuthResponse(token));

    }

    @RequestMapping("me")
    public JsonResult<User> me(String username){
        //查询用户信息
        User user = userService.getByUsername(username);
        return new JsonResult<>(JsonResult.SUCCESS_CODE,user);

    }

}
