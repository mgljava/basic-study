package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullPermutation {

  public static void main(String[] args) {
    List<List<Integer>> permute = new FullPermutation().permute(new int[] {1, 2, 3});
    System.out.println(permute);
  }

  static List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
      result.add(num);
    }
    backtrack(nums.length, result, 0);
    return ans;
  }

  public void backtrack(int n, List<Integer> result, int index) {
    if (n == index) {
      ans.add(new ArrayList<>(result));
    }
    for (int i = index; i < n; i++) {
      Collections.swap(result, index, i);
      backtrack(n, result, index + 1);
      Collections.swap(result, index, i);
    }
  }
}
