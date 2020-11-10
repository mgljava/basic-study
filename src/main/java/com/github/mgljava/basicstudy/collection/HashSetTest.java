package com.github.mgljava.basicstudy.collection;

import java.util.HashSet;

public class HashSetTest {

  public static void main(String[] args) {
    HashSet<MyObject> myObjects = new HashSet<>();
    System.out.println(myObjects.size());
    myObjects.add(new MyObject(1));
    myObjects.add(new MyObject(1));
    System.out.println(myObjects.size());
  }
}

class MyObject {

  private int id;

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  public MyObject(int id) {
    this.id = id;
  }
}