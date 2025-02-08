package com.iblog.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey = Keys.hmacShaKeyFor("SuperSecretKeyForJwtSigningSuperSecretKey".getBytes());
    private final long expirationTime = 3600000; //1小时

    //生成JWT
    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)//载荷
                .issuedAt(new Date())//设置签发时间
                .expiration(new Date(System.currentTimeMillis()+expirationTime))//设置过期时间
                .signWith(secretKey) //使用密钥签名
                .compact(); //构建JWT
    }

    //验证JWT是否有效
    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
