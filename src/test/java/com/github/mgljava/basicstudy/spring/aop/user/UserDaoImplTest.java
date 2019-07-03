package com.github.mgljava.basicstudy.spring.aop.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-aspectj.xml")
public class UserDaoImplTest {

  @Autowired
  UserDao userDao;

  @Test
  public void aspectjTest() {
    userDao.addUser();
  }
}