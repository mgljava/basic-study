package com.github.mgljava.basicstudy.jvm.memory;

import net.sf.cglib.proxy.Enhancer;

/**
 * 方法区产生内存溢出错误 在运行期不断创建MetaSpace类的子类，将元信息放置到元空间中
 */

public class MetaSpace {

  public static void main(String[] args) {
    int i = 0;
    for (; ; ) {
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(MetaSpace.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(new MyMethodInterceptor());
      System.out.println("Hello Word: " + i++);
      enhancer.create();
    }
  }
}
