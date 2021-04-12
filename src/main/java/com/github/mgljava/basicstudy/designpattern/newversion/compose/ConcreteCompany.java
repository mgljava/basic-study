package com.github.mgljava.basicstudy.designpattern.newversion.compose;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company {

  private List<Company> children = new ArrayList<>();

  public ConcreteCompany(String name) {
    super(name);
  }

  @Override
  void add(Company c) {
    children.add(c);
  }

  @Override
  void remove(Company c) {
    children.remove(c);
  }

  @Override
  void disPlay(int dept) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < dept; i++) {
      stringBuilder.append("-");
    }
    stringBuilder.append(super.name);
    System.out.println(stringBuilder.toString());
    for (Company c : children) {
      c.disPlay(dept);
    }
  }

  @Override
  void lineOfDuty() {
    for (Company c : children) {
      c.lineOfDuty();
    }
  }
}
