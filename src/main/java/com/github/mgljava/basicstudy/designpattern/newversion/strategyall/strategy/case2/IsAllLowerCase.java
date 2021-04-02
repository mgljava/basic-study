package com.github.mgljava.basicstudy.designpattern.newversion.strategyall.strategy.case2;

public class IsAllLowerCase implements ValidationStrategy {

  @Override
  public boolean execute(String string) {
    return string.matches("[a-z]+");
  }
}
