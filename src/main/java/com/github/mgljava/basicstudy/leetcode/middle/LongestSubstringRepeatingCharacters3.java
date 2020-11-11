package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringRepeatingCharacters3 {


  public static void main(String[] args) {
    int result = new LongestSubstringRepeatingCharacters3().lengthOfLongestSubstring("pwwkew");
    System.out.println(result);
  }
/*
  public int lengthOfLongestSubstring(String s) {
    if (s.equals("")) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    char[] chars = s.toCharArray();
    int maxLength = 0;
    for (int i = 0; i < chars.length; i++) {
      for (int j = i; j < chars.length; j++) {
        if (containerRepeat(s.substring(i, j+1))) {
          maxLength = Math.max(maxLength, j - i + 1);
        }
      }
    }
    return maxLength;
  }

  public boolean containerRepeat(String str) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (set.contains(c)) {
        return false;
      } else {
        set.add(c);
      }
    }
    return true;
  }

   */

  /*
  public int lengthOfLongestSubstring(String s) {
    if (s.equals("")) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        Character character = s.charAt(j);
        if (map.containsKey(character)) {
          ans = Math.max(ans, map.size());
          map.clear();
          break;
        } else {
          map.put(character, 1);
        }
      }
    }
    return ans;
  }

   */

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0;
    int left = 0;
    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);
      if (map.containsKey(character)) {
        left = Math.max(left, map.get(character) + 1);
      }
      map.put(character, i);
      ans = Math.max(ans, i - left + 1);
    }
    return ans;
  }
}
