package com.github.mgljava.basicstudy.leetcode.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
public class StringBinarySearch2 {

  public static void main(String[] args) {
    String[] strings = new String[] {"at", "ax", "", "", "ball", "", "", "car", "", "","dad", "", ""};
    System.out.println(findString(strings, "ax"));
    System.out.println("abc".compareTo("a"));
  }

  public static int findString(String[] words, String s) {
    List<String> collect = Arrays.stream(words).filter(item -> !item.equals("")).collect(Collectors.toList());
    int left = 0;
    int right = collect.size() - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (s.compareTo(collect.get(mid)) == 0) {
        return mid;
      } else if (s.compareTo(collect.get(mid)) < 0) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
