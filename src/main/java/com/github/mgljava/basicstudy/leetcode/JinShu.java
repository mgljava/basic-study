package com.github.mgljava.basicstudy.leetcode;

import java.util.ArrayList;
import java.util.List;

// 1,2,3  4
public class JinShu {

  private int sum = 0;
  private static List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    new JinShu().func(new int[] {1, 2, 3}, 4, 0, new ArrayList<>());
    System.out.println(res);
  }

  public void func(int[] nums, int k, int index, List<Integer> temp) {
    if (k == 0 || index == nums.length) {
      res.add(new ArrayList<>(temp));
      return;
    } else {
      temp.add(nums[index]);
      func(nums, k - nums[index], index + 1, temp);
      temp.remove(temp.size() - 1);
      func(nums, k - nums[index], index + 1, temp);
    }
  }
}
