package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <br>
 * 异位词：所有字母出现的次数是一样的，不考虑顺序
 */
public class ValidAnagram {

  public static void main(String[] args) {
    boolean anagram = new ValidAnagram().isAnagram3("acab", "baad");
    System.out.println(anagram);
  }

  // 1. 暴力解法 先排序在直接比较
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] charsA = s.toCharArray();
    Arrays.sort(charsA);
    char[] charsB = t.toCharArray();
    Arrays.sort(charsB);

    return Arrays.equals(charsA, charsB);
  }

  // 2. hash表来统计每个字符的频次
  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  // 3. hash表来统计每个字符的频次
  public boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      if (map.get(t.charAt(i)) == null) {
        return false;
      } else if (map.get(t.charAt(i)) == 1) {
        map.remove(t.charAt(i));
      } else {
        map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
      }
    }
    return map.isEmpty();
  }
}
