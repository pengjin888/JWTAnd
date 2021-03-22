package com.controller;

import com.po.UserInfo;
import com.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Version 1.0
 * @Author:penguins Shaw
 * @Date: 2021 03 2021-03-21 22:01
 * Description: No Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserInfo user){
        return userService.login(user);
    }

    @PostMapping("/logout")
    public void logout(){
        //todo
    }
}