package com.github.mgljava.basicstudy;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Service.class);
    System.out.println(beansWithAnnotation);
  }

  public void sayHello(String name) {
    System.out.println("name : " + name);
  }
}
