package com.iblog.config;

import com.iblog.Interceptor.JwtInterceptor;
import com.iblog.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final JwtUtil jwtUtil;

    @Autowired
    public WebConfig (JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor(jwtUtil))
                .addPathPatterns("/api/comments/**")//只拦截Comments操作
                .excludePathPatterns("/api/register"); // 排除 /api/register

    }
}
