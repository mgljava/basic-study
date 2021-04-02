package com.github.mgljava.basicstudy.designpattern.newversion.proxy.dynamic;


public class MainTest {

  public static void main(String[] args) {

    BookFacadeProxy proxy = new BookFacadeProxy();
    BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
    bookFacade.addBook();
    bookFacade.updateBook();
  }
}
