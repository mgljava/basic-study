package com.github.mgljava.basicstudy.jvm.classloader;

/**
 * 删掉字节码文件,并且设置了类加载的路径
 * 1. 如果删除classpath下的MySample和MyCat，那么类加载器将从Desktop下加载class文件
 * 2. 如果删除掉MySample，那么MySample将会从Desktop加载，而MyCat将会由我们自定义的类加载器的父类 AppClassLoader进行加载
 * 3. 如果删掉MyCat， 那么MySample会由App ClassLoader加载，而在加载MyCat的时候会失败，因为该类已经被删除。那为什么不从DeskTop进行加载呢？
 * 因为MySample加载的时候使用的是App ClassLoader，其父类都无法加载MyCat，classpath下也没有该class文件，那么将会抛出异常（类找不到）
 */

public class MyClassLoaderTest2_1 {

  public static void main(String[] args) throws Exception{
    MyClassLoader loader1 = new MyClassLoader("loader1");
    loader1.setPath("/Users/monk/Desktop/");
    Class<?> clazz = loader1.loadClass("com.github.mgljava.basicstudy.jvm.classloader.MySample");
    System.out.println("class : " + clazz.hashCode());

    // 生成类的实例，就会实例化MySample对象，执行构造方法
    Object o = clazz.newInstance();

  }
}
