package com.github.mgljava.basicstudy.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcClassLoaderTest {

  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "123456");
    System.out.println(connection);
  }
}
