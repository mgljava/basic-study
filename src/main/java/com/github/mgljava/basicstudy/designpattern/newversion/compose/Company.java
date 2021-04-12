package com.github.mgljava.basicstudy.designpattern.newversion.compose;

public abstract class Company {

  protected String name;

  public Company(String name) {
    this.name = name;
  }

  abstract void add(Company c); // 增加

  abstract void remove(Company c); // 移除

  abstract void disPlay(int dept); // 展示

  abstract void lineOfDuty(); // 履行职责
}
