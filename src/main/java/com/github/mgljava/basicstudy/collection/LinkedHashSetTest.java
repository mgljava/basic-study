package com.github.mgljava.basicstudy.collection;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

  public static void main(String[] args) {
    LinkedHashSet<String> hashSet = new LinkedHashSet<>();
    hashSet.add("hello");
    hashSet.add("world");
    hashSet.add("abds");
    hashSet.add("zswe");
    hashSet.add("bdsq");
    hashSet.forEach(System.out::println);
  }
}
