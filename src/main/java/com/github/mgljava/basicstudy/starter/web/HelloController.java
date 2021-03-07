package com.github.mgljava.basicstudy.starter.web;

import com.github.mgljava.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private HelloService helloService;

  @GetMapping("starter/hello")
  public String sayName(@RequestParam("name") String name) {
    return helloService.sayHello(name);
  }
}
