package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

public class AndroidUIController implements UIController {

  @Override
  public void display() {
    System.out.println("AndroidInterfaceController");
  }
}
