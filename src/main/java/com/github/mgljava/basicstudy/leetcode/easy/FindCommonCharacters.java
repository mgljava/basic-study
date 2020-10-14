package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

  public static void main(String[] args) {
    List<String> strings = new FindCommonCharacters().commonChars(new String[] {"bella", "label", "roller"});
    System.out.println(strings);
  }

  public List<String> commonChars(String[] A) {

    List<String> ans = new ArrayList<>();
    int[] res = new int[26];

    // 将第一个字符串中所有出现的字符进行统计
    for (char c : A[0].toCharArray()) {
      res[c - 'a']++;
    }

    for (int i = 1; i < A.length; i++) {
      int[] temp = new int[26];
      for (char c : A[i].toCharArray()) {
        temp[c - 'a']++;
      }
      for (int j = 0; j < 26; j++) {
        res[j] = Math.min(res[j], temp[j]);
      }
    }

    for (int i = 0; i < res.length; i++) {
      if (res[i] > 0) {
        for (int j = 0; j < res[i]; j++) {
          ans.add(((char)('a' + i) + ""));
        }
      }
    }
    return ans;
  }
}
