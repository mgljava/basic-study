package com.github.mgljava.basicstudy.designpattern.newversion.strategyall.strategy_;

public class RsaStrategy implements Strategy {

  @Override
  public void encrypt() {
    System.out.println("RSA 加密");
  }
}
