package com.github.mgljava.basicstudy.designpattern.newversion.memento;

// 备忘录管理者
public class Caretaker {

  private Memento memento;

  public Memento getMemento() {
    return memento;
  }

  public void setMemento(Memento memento) {
    this.memento = memento;
  }
}
