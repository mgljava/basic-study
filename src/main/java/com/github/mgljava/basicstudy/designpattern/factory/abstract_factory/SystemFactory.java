package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

// 抽象工厂，该工厂需要可以创建OperationController和UIController
public interface SystemFactory {

  OperationController createOperationController();

  UIController createInterfaceController();
}
