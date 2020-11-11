package com.github.mgljava.basicstudy.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

public class HashMapTest {

  public static void main(String[] args) {
    final Map<String, String> map = new HashMap<>();
    IntStream.range(0, 1000)
        .forEach(i -> new Thread(() -> map.put(UUID.randomUUID().toString(), "hello")).start());
    System.out.println(map.size());
  }
}
