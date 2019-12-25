package com.github.mgljava.basicstudy.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// 自定义类加载器
public class MyClassLoader extends ClassLoader {

  private String classLoaderName;
  private String fileExtension = ".class";
  private String path;

  public void setPath(String path) {
    this.path = path;
  }

  public MyClassLoader(String classLoaderName) {
    super(); // 将系统类加载器作为该类的父加载器
    this.classLoaderName = classLoaderName;
  }

  public MyClassLoader(ClassLoader parent, String classLoaderName) {
    super(parent); // 显示指定父加载器
    this.classLoaderName = classLoaderName;
  }

  @Override
  protected Class<?> findClass(String className) {
    System.out.println("find class invoked! : " + className);
    System.out.println("class loader name : " + classLoaderName);

    byte[] bytes = this.loadClassData(className);
    return defineClass(className, bytes, 0, bytes.length);
  }

  private byte[] loadClassData(String className) {
    InputStream is = null;
    byte[] data = null;
    ByteArrayOutputStream byteArrayOutputStream = null;
    try {
      className = className.replace(".", "/");
      is = new FileInputStream(new File(this.path + className + this.fileExtension));
      byteArrayOutputStream = new ByteArrayOutputStream();
      int ch;
      while (-1 != (ch = is.read())) {
        byteArrayOutputStream.write(ch);
      }
      data = byteArrayOutputStream.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (null != is) {
          is.close();
        }
        if (null != byteArrayOutputStream) {
          byteArrayOutputStream.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return data;
  }

  public static void main(String[] args) throws Exception {
    loadingCLass();
    // unloadingClass();
  }

  private static void unloadingClass() throws Exception {
    // JVM 参数： -XX:+TraceClassUnloading  可以查看类的卸载情况
    MyClassLoader loader1 = new MyClassLoader("loader1");
    loader1.setPath("/Users/monk/Desktop/");

    Class<?> aClass = loader1.loadClass("com.github.mgljava.basicstudy.Application");
    System.out.println("class : " + aClass.hashCode());
    Object instance = aClass.newInstance();
    System.out.println(instance);
    System.out.println(instance.getClass().getClassLoader());
    System.out.println();
    loader1 = null;
    aClass = null;
    instance = null;

    System.gc(); // 执行 gc方法后  JVM输出： [Unloading class com.github.mgljava.basicstudy.Application 0x00000007c0061028]
    Thread.sleep(100000);
    loader1 = new MyClassLoader("loader1");
    loader1.setPath("/Users/monk/Desktop/");

    aClass = loader1.loadClass("com.github.mgljava.basicstudy.Application");
    System.out.println("class : " + aClass.hashCode());
    instance = aClass.newInstance();
    System.out.println(instance);
    System.out.println(instance.getClass().getClassLoader());
    System.out.println();
  }

  private static void loadingCLass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    // MyClassLoader loader1 = new MyClassLoader(new MyClassLoader("loader2"), "loader1");
    MyClassLoader loader1 = new MyClassLoader("loader1");
    loader1.setPath("/Users/monk/Desktop/");

    Class<?> aClass = loader1.loadClass("com.github.mgljava.basicstudy.Application");
    System.out.println("class : " + aClass.hashCode());
    Object instance = aClass.newInstance();
    System.out.println(instance);
    System.out.println(instance.getClass().getClassLoader());
    System.out.println();

    // MyClassLoader loader2 = new MyClassLoader("loader2"); // 都有自己的类加载器和命名空间
    MyClassLoader loader2 = new MyClassLoader(loader1, "loader2"); // 如果显示指定 loader2的父加载器，那么该类将有父加载器加载
    loader2.setPath("/Desktop/");

    Class<?> bClass = loader2.loadClass("com.github.mgljava.basicstudy.Application");
    System.out.println("class : " + bClass.hashCode());
    Object instance2 = bClass.newInstance();
    System.out.println(instance2);
    System.out.println(instance2.getClass().getClassLoader());
  }
}
