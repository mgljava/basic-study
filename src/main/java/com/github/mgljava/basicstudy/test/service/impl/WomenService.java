package com.github.mgljava.basicstudy.test.service.impl;

import com.github.mgljava.basicstudy.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class WomenService implements UserService {

    @Override
    public void sayHello() {
        System.out.println("women say hello!");
    }
}
