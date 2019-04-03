package com.example.model;

import io.swagger.annotations.ApiModelProperty;

public class UserForm {
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "000000")
    private String password;

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
}
