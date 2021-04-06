package com.github.mgljava.basicstudy.designpattern.newversion.observer;

import java.util.ArrayList;
import java.util.List;

// 主题（抽象通知类）
public interface Subject {

  List<Observer> observers = new ArrayList<>();

  // 增加观察者
  void addObserver(Observer observer);

  // 移除观察者
  void deleteObserver(Observer observer);

  // 通知所有观察者
  void notifyAllObserver();
}
