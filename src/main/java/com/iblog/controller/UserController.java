package com.iblog.controller;

import com.iblog.entity.User;
import com.iblog.service.IUserService;
import com.iblog.service.impl.UserServiceImpl;
import com.iblog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//处理用户相关请求的控制器类
@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private IUserService userService;

    @RequestMapping("/register")
    public JsonResult<Void> reg(User user){
        //调用业务对象执行注册
        userService.reg(user);
        //返回
        return new JsonResult<>(JsonResult.SUCCESS_CODE);
    }

}
