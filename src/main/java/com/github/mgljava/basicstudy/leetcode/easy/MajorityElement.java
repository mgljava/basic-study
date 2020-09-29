package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// 找出数组中出现次数最多的数字
public class MajorityElement {

  public static void main(String[] args) {
    int i = new MajorityElement().majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2});
    System.out.println(i);
  }

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    return map.entrySet()
        .stream().sorted((o1, o2) -> {
          if (o1.getValue() < o2.getValue()) {
            return 1;
          } else if (o1.getValue().equals(o2.getValue())) {
            return 0;
          }
          return -1;
        }).findFirst().get().getKey();
  }
}
