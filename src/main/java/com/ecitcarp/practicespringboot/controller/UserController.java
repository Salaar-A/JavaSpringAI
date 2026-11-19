package com.ecitcarp.practicespringboot.controller;

import com.ecitcarp.practicespringboot.model.User;
import com.ecitcarp.practicespringboot.service.LoginService;
import com.ecitcarp.practicespringboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    private final LoginService loginService;

    public UserController(UserService userService,LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return loginService.validateLogin(user);
    }
}
