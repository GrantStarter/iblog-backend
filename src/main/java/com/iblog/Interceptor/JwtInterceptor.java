package com.iblog.Interceptor;

import com.iblog.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 自定义拦截处理器*/
public class JwtInterceptor implements HandlerInterceptor {
    private final JwtUtil jwtUtil;

    public  JwtInterceptor(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        if(token != null && token.startsWith("Bearer")){
            token.substring(7);
            if(jwtUtil.validateToken(token)){
                return true; //认证通过，放行请求
            }

        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized");
        return false; //拦截请求
    }
}
