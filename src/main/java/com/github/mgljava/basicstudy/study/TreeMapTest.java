package com.github.mgljava.basicstudy.study;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

  public static void main(String[] args) {
    Map<String, String> hashMap = new HashMap<>();
    hashMap.put("aa", "aa");
    hashMap.put("bb", "bb");
    hashMap.put("ab", "ab");

    System.out.println(hashMap);

    Map<String, String> treeMap = new TreeMap<>();
    treeMap.put("aa", "aa");
    treeMap.put("bb", "bb");
    treeMap.put("ab", "ab");

    System.out.println(treeMap);

    Map<User, String> map = new HashMap<>();
    map.put(new User(1), "1");
    map.put(new User(2), "2");
    System.out.println(map);

    Map<User, String> treeMap1 = new TreeMap<>();
    treeMap1.put(new User(22), "22");
    treeMap1.put(new User(1), "1");
    treeMap1.put(new User(112), "112");
    treeMap1.put(new User(2), "2");
    treeMap1.put(new User(11), "11");
    System.out.println(treeMap1);
  }
}

// 需要实现 Comparable 接口
class User implements Comparable<User> {

  private int id;

  User(int id) {
    this.id = id;
  }

  @Override
  public int compareTo(User o) {
    return - (this.id - o.id);
  }
}
