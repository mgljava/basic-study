package com.github.mgljava.basicstudy.designpattern.newversion.strategyall.strategy_;

public class AesStrategy implements Strategy{

  @Override
  public void encrypt() {
    System.out.println("AES 加密");
  }
}
