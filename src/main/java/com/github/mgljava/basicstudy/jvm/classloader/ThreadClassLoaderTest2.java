package com.github.mgljava.basicstudy.jvm.classloader;

public class ThreadClassLoaderTest2 implements Runnable {

  private Thread thread;

  public ThreadClassLoaderTest2() {
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {

    ClassLoader contextClassLoader = this.thread.getContextClassLoader();
    this.thread.setContextClassLoader(contextClassLoader);

    System.out.println("class : " + contextClassLoader.getClass());
    System.out.println("parent : " + contextClassLoader.getParent().getClass());
  }

  public static void main(String[] args) {
    new ThreadClassLoaderTest2();
  }
}
