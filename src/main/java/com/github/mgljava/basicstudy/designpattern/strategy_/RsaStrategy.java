package com.github.mgljava.basicstudy.designpattern.strategy_;

public class RsaStrategy implements Strategy {

  @Override
  public void encrypt() {
    System.out.println("RSA 加密");
  }
}
