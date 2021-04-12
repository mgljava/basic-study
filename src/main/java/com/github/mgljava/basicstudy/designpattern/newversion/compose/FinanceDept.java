package com.github.mgljava.basicstudy.designpattern.newversion.compose;

public class FinanceDept extends Company {

  public FinanceDept(String name) {
    super(name);
  }

  @Override
  void add(Company c) {

  }

  @Override
  void remove(Company c) {

  }

  @Override
  void disPlay(int dept) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < dept; i++) {
      stringBuilder.append("-");
    }
    stringBuilder.append(super.name);
    System.out.println(stringBuilder.toString());
  }

  @Override
  void lineOfDuty() {
    System.out.println(super.name + " 公司财务收支管理");
  }
}
