package com.github.mgljava.basicstudy.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderTest {

  public static void main(String[] args) {

    // 如果加上此行代码，那么MySQL的驱动就无法加载，因为扩展类加载器无法加载类路径下的jar包
    // Thread.currentThread().setContextClassLoader(ServiceLoaderTest.class.getClassLoader().getParent());

    // 如果换成自定义类加载器，那么是可以加载的，因为自定义类加载器就是应用类加载器来加载的
    System.out.println(MyClassLoader.class.getClassLoader()); // AppClassLoader
    Thread.currentThread().setContextClassLoader(MyClassLoader.class.getClassLoader());

    ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
    Iterator<Driver> iterator = loader.iterator();
    while (iterator.hasNext()) {
      Driver driver = iterator.next();
      System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
    }

    System.out.println("当前线程上下文类加载器:" + Thread.currentThread().getContextClassLoader());
    System.out.println(ServiceLoader.class.getClassLoader());
  }
}
