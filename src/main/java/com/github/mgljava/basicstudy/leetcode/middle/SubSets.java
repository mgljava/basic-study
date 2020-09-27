package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

  public static void main(String[] args) {
    List<List<Integer>> subsets = new SubSets().subsets2(new int[] {1, 2, 3});
    System.out.println(subsets);
  }

  // 递归
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, nums, new ArrayList<>(), 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
    if (index == nums.length) {
      ans.add(new ArrayList<>(list));
      return;
    }

    dfs(ans, nums, list, index + 1);
    list.add(nums[index]);
    dfs(ans, nums, list, index + 1);
    list.remove(list.size() - 1);
  }

  List<List<Integer>> ans = new ArrayList<>();

  // 回溯法
  public List<List<Integer>> subsets2(int[] nums) {
    backtrack(0, nums, new ArrayList<>());
    return ans;
  }

  private void backtrack(int index, int[] nums, List<Integer> temp) {
    if (nums.length == index) {
      ans.add(new ArrayList<>(temp));
    } else {
      temp.add(nums[index]);
      backtrack(index + 1, nums, temp);
      temp.remove(temp.size() - 1);
      backtrack(index + 1, nums, temp);
    }
  }
}
