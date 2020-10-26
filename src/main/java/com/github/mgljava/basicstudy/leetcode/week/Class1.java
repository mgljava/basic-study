package com.github.mgljava.basicstudy.leetcode.week;

import java.util.HashMap;
import java.util.Map;

public class Class1 {

  public static void main(String[] args) {
    char cbcd = new Class1().slowestKey(new int[] {9,29,49,50}, "cbcd");
    System.out.println(cbcd);
  }

  public char slowestKey(int[] releaseTimes, String keysPressed) {
    if (releaseTimes.length != keysPressed.length()) {
      return 0;
    }
    char[] chars = keysPressed.toCharArray();
    Map<Integer, Character> map = new HashMap<>();
    map.put(releaseTimes[0], chars[0]);
    for (int i = 1; i < chars.length; i++) {
      int key = releaseTimes[i] - releaseTimes[i - 1];
      if (map.get(key) != null) {
        Character character = map.get(key);
        if (character < chars[i]) {
          map.put(key, chars[i]);
        }
      } else {
        map.put(key, chars[i]);
      }
    }
    Integer integer = map.keySet().stream().sorted((o1, o2) -> {
      if (o1.equals(o2)) {
        return 0;
      } else if (o1 > o2) {
        return -1;
      }
      return 1;
    }).findFirst().get();
    return map.get(integer);
  }
}
