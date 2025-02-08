package com.iblog.service.impl;

import com.iblog.entity.User;
import com.iblog.mapper.UserMapper;
import com.iblog.service.IUserService;
import com.iblog.service.ex.InsertException;
import com.iblog.service.ex.LoginException;
import com.iblog.service.ex.UsernameDuplicateException;
import com.iblog.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/** 处理用户数据的业务曾实现类*/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    //注册
    @Override
    public void reg(User user) {
        //获取用户名字
        String username = user.getUsername();

        //查询用户信息
        User result = userMapper.findByUsername(username);

        //检验用户信息
        if(result != null){
            //用户信息已被占用
            throw new UsernameDuplicateException("用户名已存在");
        }

        //创建时间对象
        Date now = new Date();

        //加密密码
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        //补全数据：4项日志属性
        user.setCreatedUser(username);
        user.setcreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);

        //数据库操作
        Integer rows = userMapper.insert(user);
        if (rows!=1){
            throw new InsertException("添加用户数据出现未知错误");
        }
    }

    //登录
    @Override
    public String login(String username, String password) {
        //获取用户信息
        User user = userMapper.findByUsername(username);

        if(user!=null && passwordEncoder.matches(password,user.getPassword())){
            return jwtUtil.generateToken(username);
        }
        throw new LoginException("用户名或密码错误");
    }

    //查询用户信息
    @Override
    public User getByUsername(String username){
        User user = userMapper.findByUsername(username);
        if(user!=null){
            user.setPassword(null);
            return user;
        }
        throw new UsernameNotFoundException("用户不存在");
    }

}
