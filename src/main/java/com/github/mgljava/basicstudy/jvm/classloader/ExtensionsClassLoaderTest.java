package com.github.mgljava.basicstudy.jvm.classloader;

import sun.misc.Launcher;

/**
 * 扩展类加载器: 修改扩展类加载器的加载路径： java -Djava.ext.dirs=./ com.github.mgljava.basicstudy.jvm.classloader.ExtensionsClassLoaderTest
 * 扩展类加载器加载的方式是加载 jar 包，不能直接加载class类型的文件
 * 打jar包的命令：jar cvf test.jar com/github/mgljava/basicstudy/jvm/classloader/ExtensionsClassLoaderTest.class
 */

public class ExtensionsClassLoaderTest {

  static {
    System.out.println("ExtensionsClassLoaderTest initializer.");
  }

  public static void main(String[] args) {
    System.out.println(ClassLoaderPathTest.class.getClassLoader());
    System.out.println(ExtensionsClassLoaderTest.class.getClassLoader());
    System.out.println(Launcher.class.getClassLoader()); // null

    // 扩展类加载器和系统类加载器也是由启动类加载器加载的
    System.out.println(ClassLoader.class.getClassLoader()); // null 由根加载器加载
    System.out.println(ClassLoader.getSystemClassLoader());
    System.out.println("-------------------");
    System.out.println(System.getProperty("java.system.class.loader")); // 获取系统类加载器
  }
}
