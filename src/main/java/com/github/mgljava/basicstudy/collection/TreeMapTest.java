package com.github.mgljava.basicstudy.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {

  public static void main(String[] args) {
    Comparator<String> comparator = (o1, o2) -> {
      if (o1.compareTo(o2) == 0) {
        return 0;
      } else if (o1.compareTo(o2) > 0) {
        return -1;
      } else {
        return 1;
      }
    };
    TreeMap<String, String> map = new TreeMap<>(comparator);
    map.put("hello", "hello");
    map.put("world", "world");
    map.put("helw", "helw");
    map.put("zzd", "zzd");
    map.put("avd", "avd");

    map.forEach((key, value) -> System.out.println(key + " -> " + value));
    System.out.println("---------");
    TreeMap<MyKey, String> myKeyStringTreeMap = new TreeMap<>();
    myKeyStringTreeMap.put(new MyKey(1), "hello");
    myKeyStringTreeMap.put(new MyKey(2), "hello");
    myKeyStringTreeMap.put(new MyKey(9), "hello");
    myKeyStringTreeMap.put(new MyKey(7), "hello");
    myKeyStringTreeMap.put(new MyKey(3), "hello");
    myKeyStringTreeMap.forEach((key, value) -> System.out.println(key + " -> " + value));
  }
}

class MyKey implements Comparable<MyKey> {

  private int id;

  public MyKey(int id) {
    this.id = id;
  }

  @Override
  public int compareTo(MyKey o) {
    if (id == o.id) {
      return 0;
    } else if (id > o.id) {
      return -1;
    } else {
      return 1;
    }
  }

  @Override
  public String toString() {
    return "id:" + id;
  }
}
