package com.github.mgljava.basicstudy.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AuthAspect {

  @Pointcut("@annotation(Auth)")
  public void authPointCut() {

  }

  @Before("authPointCut()")
  public void authorizationCheck(JoinPoint joinPoint) {
    final Object[] args = joinPoint.getArgs();
    System.out.println(args[0]);
  }
}
