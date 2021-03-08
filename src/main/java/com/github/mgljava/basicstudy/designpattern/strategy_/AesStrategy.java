package com.github.mgljava.basicstudy.designpattern.strategy_;

public class AesStrategy implements Strategy{

  @Override
  public void encrypt() {
    System.out.println("AES 加密");
  }
}
