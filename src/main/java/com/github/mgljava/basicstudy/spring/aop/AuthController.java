package com.github.mgljava.basicstudy.spring.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Auth
  @GetMapping("/sayName")
  public String sayName(@RequestParam String name) {
    System.out.println(name);
    return name;
  }
}
