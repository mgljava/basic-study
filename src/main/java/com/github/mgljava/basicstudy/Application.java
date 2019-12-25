package com.github.mgljava.basicstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  public void sayHello(String name) {
    System.out.println("name : " + name);
  }
}
