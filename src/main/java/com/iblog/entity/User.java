package com.iblog.entity;

import java.io.Serializable;
import java.util.Objects;

public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String email;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 如果是同一个对象，直接返回 true
        if (!(o instanceof User)) return false; // 如果对象不是 User 类型，返回 false

        User user = (User) o; // 强制转换为 User 类型

        // 比较 uid, username, password, email
        return Objects.equals(getUid(), user.getUid()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password, email);
    }
}
