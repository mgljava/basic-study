package com.github.mgljava.basicstudy.leetcode.easy;

public class RemoveElement27 {

  public int removeElement(int[] nums, int val) {
    int count = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] == val) {
        nums[i] = nums[i+1];
        n--;
        count++;
      }
    }
    return nums.length - count;
  }
}
