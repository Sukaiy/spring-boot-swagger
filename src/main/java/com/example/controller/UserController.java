package com.example.controller;

import com.example.model.User;
import com.example.model.UserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户", description = "用户")
@RequestMapping("/user")
@RestController
public class UserController {

    @ApiOperation(value = "登录", notes = "输入用户名和密码登录")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class, responseContainer = "user"),
            @ApiResponse(code = 405, message = "账号名或密码错误")
    })
    @RequestMapping(value = "/login", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<User> login(@RequestBody UserForm form) {
        if (!form.getPassword().equalsIgnoreCase("000000")) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        }
        User user = new User();
        user.setId(1L);
        user.setUsername(form.getUsername());
        user.setFirstName("小");
        user.setLastName("明");
        user.setEmail("xiaoming@mail.com");
        user.setUserStatus(1);
        return ResponseEntity.ok(user);
    }
}
