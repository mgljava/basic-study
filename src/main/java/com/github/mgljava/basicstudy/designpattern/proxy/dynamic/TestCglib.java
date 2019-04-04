package com.github.mgljava.basicstudy.designpattern.proxy.dynamic;

public class TestCglib {

  public static void main(String[] args) {
    BookFacadeCglibProxy proxy = new BookFacadeCglibProxy();

    BookFacadeNoImpl bookFacadeNo = (BookFacadeNoImpl) proxy.getInstance(new BookFacadeNoImpl());

    bookFacadeNo.addBook();
  }
}
