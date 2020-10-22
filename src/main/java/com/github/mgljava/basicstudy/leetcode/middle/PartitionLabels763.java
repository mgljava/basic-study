package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

  public static void main(String[] args) {
    List<Integer> integers = new PartitionLabels763().partitionLabels("ababcbacadefegdehijhklij");
    System.out.println(integers);
  }

  public List<Integer> partitionLabels(String S) {
    if (S == null || S.length() == 0) {
      return new ArrayList<>();
    }
    char[] chars = S.toCharArray();
    int[] cache = new int[26];
    for (int i = 0; i < chars.length; i++) {
      cache[chars[i] - 'a'] = i;
    }
    List<Integer> ans = new ArrayList<>();
    int i = 0;
    int index;
    while (i < chars.length) {
      index = cache[chars[i] - 'a'];
      for (int j = i + 1; j < index; j++) {
        if (cache[chars[j] - 'a'] > index) {
          index = cache[chars[j] - 'a'];
        }
      }
      ans.add(index - i + 1);
      i = index + 1;
    }
    return ans;
  }
}
