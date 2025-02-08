package com.iblog.service;

import com.iblog.entity.User;

public interface IUserService {
    /**
     * 用户注册
     * @param user 用户数据
     */
    void reg(User user);

    /**\
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return JWT token
     */
    String login(String username,String password);

    /**
     * 获取当前登录的用户的信息 
     * @param username 当前登录的用户的名字
     * @return 当前登录的用户的信息
     */
    User getByUsername(String username);
}
