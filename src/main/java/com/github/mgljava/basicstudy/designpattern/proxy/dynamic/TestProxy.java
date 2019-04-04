package com.github.mgljava.basicstudy.designpattern.proxy.dynamic;

public class TestProxy {

  public static void main(String[] args) {

    BookFacadeProxy proxy = new BookFacadeProxy();
    BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
    bookFacade.addBook();
    bookFacade.updateBook();

    CityFacade cityFacade = (CityFacade) proxy.bind(new CityFacadeImpl());
    cityFacade.addCity();

    /**
     * JDK自带的动态代理必须实现接口
     */
    /*UserFacade userFacade = (UserFacade) proxy.bind(new UserFacade());
    userFacade.addUser();*/
  }
}
