package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopK {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5, 56, 66, 66, 56};
    Arrays.stream(topKFrequent(nums, 2)).forEach(System.out::println);
  }

  public static int[] topKFrequent(int[] nums, int k) {
    TreeMap<Integer, Integer> result = new TreeMap<>();
    for (int i = 0; i <= nums.length - 1; i++) {
      result.put(nums[i], result.getOrDefault(nums[i], 0) + 1);
    }
    int size = result.entrySet().size();
    List<Integer> list = result.entrySet().stream().sorted(Entry.comparingByValue())
        .skip(size - k).map(Entry::getKey).collect(Collectors.toList());
    int[] response = new int[k];
    for (int i = 0; i < k; i++) {
      response[i] = list.get(i);
    }
    return response;
  }
}
