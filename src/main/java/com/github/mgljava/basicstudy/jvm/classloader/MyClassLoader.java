package com.github.mgljava.basicstudy.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// 自定义类加载器
public class MyClassLoader extends ClassLoader {

  private String classLoaderName;
  public final String fileExtension = ".class";

  public MyClassLoader(String classLoaderName) {
    super(); // 将系统类加载器作为该类的父加载器
    this.classLoaderName = classLoaderName;
  }

  public MyClassLoader(ClassLoader parent, String classLoaderName) {
    super(parent); // 显示指定父加载器
    this.classLoaderName = classLoaderName;
  }

  @Override
  protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
    byte[] bytes = this.loadClassData(className);
    return defineClass(className, bytes, 0, bytes.length);
  }

  private byte[] loadClassData(String className) {
    InputStream is = null;
    byte[] data = null;
    ByteArrayOutputStream byteArrayOutputStream = null;
    try {
      is = new FileInputStream(new File(className + this.fileExtension));
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

  public static void test(ClassLoader classLoader) throws Exception {
    Class<?> aClass = classLoader.loadClass("com.github.mgljava.basicstudy.Application");
    Object object = aClass.newInstance();

    System.out.println(object);
  }

  public static void main(String[] args) throws Exception {
    test(new MyClassLoader("loader1"));
  }
}
