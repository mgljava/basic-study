package com.github.mgljava.basicstudy.test.controller;

import com.github.mgljava.basicstudy.test.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Resource(name = "manService")
    private UserService userService;

    @GetMapping
    public void sayHello() {
        userService.sayHello();
    }
}
