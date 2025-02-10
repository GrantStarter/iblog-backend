package com.iblog.util;

/** Token对象
 * @author NiceChen
 * @create 2025-02-10 9:51 PM
 */
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
