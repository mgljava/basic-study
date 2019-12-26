package com.github.mgljava.basicstudy.jvm.classloader;

import java.lang.reflect.Method;

public class MyPersonTest {

  public static void main(String[] args) throws Exception{

    MyClassLoader loader1 = new MyClassLoader("loader1");
    MyClassLoader loader2 = new MyClassLoader("loader2");
    loader1.setPath("/Users/monk/Desktop/");
    loader2.setPath("/Users/monk/Desktop/");

    // 如果都是从桌面加载，那这两个类没有关联关系，都有各自的命名空间
    Class<?> class1 = loader1.loadClass("com.github.mgljava.basicstudy.jvm.classloader.MyPerson");
    Class<?> class2 = loader2.loadClass("com.github.mgljava.basicstudy.jvm.classloader.MyPerson");

    System.out.println(class1.hashCode());
    System.out.println(class2.hashCode());
    // 返回 true，因为只有一份，因为都是交由App ClassLoader来加载的
    System.out.println(class1 == class2);

    Object object1 = class1.newInstance();
    Object object2 = class2.newInstance();

    // 返回 false，不同的对象
    System.out.println(object1 == object2);

    Method method = class1.getMethod("setMyPerson", Object.class);
    method.invoke(object1, object2);
  }
}
