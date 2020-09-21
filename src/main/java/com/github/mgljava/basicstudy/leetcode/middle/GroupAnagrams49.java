package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

  public static void main(String[] args) {
    List<List<String>> result = new GroupAnagrams49().groupAnagrams(new String[] {"abc", "acb", "ee", "ww", "adsew"});
    System.out.println(result);
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String keys = new String(chars);
      if (!map.containsKey(keys)) {
        map.put(keys, new ArrayList<>());
      }
      map.get(keys).add(str);
    }
    return new ArrayList<>(map.values());
  }
}
