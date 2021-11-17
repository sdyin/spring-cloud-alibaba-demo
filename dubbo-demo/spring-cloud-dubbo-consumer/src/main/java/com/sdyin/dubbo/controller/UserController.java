package com.sdyin.dubbo.controller;

import com.sdyin.dubbo.api.UserService;
import com.sdyin.dubbo.entity.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/17$ 10:01 下午$
 */
@RestController
@RequestMapping("/dubbo/user")
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
}
