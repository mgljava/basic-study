package com.github.mgljava.basicstudy.designpattern.strategy_;

public class Md5Strategy implements Strategy {

  @Override
  public void encrypt() {
    System.out.println("MD5 加密");
  }
}
