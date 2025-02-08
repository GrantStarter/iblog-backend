package com.iblog;

import com.iblog.entity.User;
import com.iblog.mapper.UserMapper;
import com.iblog.service.impl.UserServiceImpl;
import com.iblog.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class IblogApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
    }

    //测试Insert
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("Admin");
        user.setPassword("abc123");
        userMapper.insert(user);
        System.out.println("插入成功，生成的uid："+user.getUid());
    }

    //测试FindByUsername
    @Test
    public void testFindByUsername(){
        User user = userMapper.findByUsername("jason");
        System.out.println(user);

    }

    //测试findByUid
    @Test
    public void testFindByUid(){
        User user = userMapper.findByUid(1);
        System.out.println(user);

    }

    //测试updatePasswordByUid
    @Test
    public void testUpdatePasswordByUid(){
        Integer result = userMapper.updatePasswordByUid(1, "123", "Admin", new Date());
        if (result !=0 ){
            System.out.println("更新成功");
        }

    }

    //测试JWT工具类
    @Test
    public void testJWT(){
        String token = jwtUtil.generateToken("Jason");
        System.out.println(token);
        boolean result = jwtUtil.validateToken(token);
        System.out.println(result);
    }

    //测试Userserivceimpl
    @Test
    public void testUserServiceReg(){
        //模拟用户传过来的数据
        User user = new User();
        user.setUsername("Jason");
        user.setPassword("abc123");
        user.setEmail("abc@qq.com");

        userService.reg(user);
    }

    //测试Userserivceimpl
    @Test
    public void testUserServiceLogin(){

        String token = userService.login("Jason", "abc123");
        System.out.println(token);
    }

    //测试Userserivceimpl
    @Test
    public void testUserServiceGetByUsername(){

        User user = userService.getByUsername("Jason");
        System.out.println(user);
    }
}
