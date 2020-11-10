package com.github.mgljava.basicstudy.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

  public static void main(String[] args) {
    TreeSet<String> stringSet = new TreeSet<>();
    stringSet.add("hello");
    stringSet.add("world");
    stringSet.add("helw");
    stringSet.add("zda");
    stringSet.add("adw");

    stringSet.forEach(System.out::println);
  }
}
