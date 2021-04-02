package com.github.mgljava.basicstudy.designpattern.newversion.proxy.dynamic;

public class BookFacadeImpl implements BookFacade {

  @Override
  public void updateBook() {
    System.out.println("修改图书方法");
  }

  @Override
  public void addBook() {
    System.out.println("增加图书方法...");
  }
}
