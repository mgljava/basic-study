package com.github.mgljava.basicstudy.designpattern.memento;

public class MainTest {

  public static void main(String[] args) {
    Person person = new Person("张三", "男", 21);
    Caretaker caretaker = new Caretaker();
    caretaker.setMemento(person.createMemento());
    System.out.println(person.toString());

    // 进行修改
    person.setName("李四");
    System.out.println(person.toString());

    // 回复到原来的状态
    person.setMemento(caretaker.getMemento());
    System.out.println(person.toString());
  }
}
