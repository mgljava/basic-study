package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

public class MainTest {

  public static void main(String[] args) {

    SystemFactory systemFactory;
    UIController uiController;
    OperationController operationController;

    systemFactory = new AndroidFactory();
    operationController = systemFactory.createOperationController();
    operationController.control();
    uiController = systemFactory.createInterfaceController();
    uiController.display();


  }
}
