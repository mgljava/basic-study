package com.github.mgljava.basicstudy.leetcode.middle;

// 55 跳跃游戏
public class JumpGame55 {

  public static void main(String[] args) {
    boolean b = new JumpGame55().canJump(new int[] {2, 3, 1, 1, 4});
    System.out.println(b);
  }

  public boolean canJump(int[] nums) {
    if (nums == null) {
      return false;
    }
    int end = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] + i >= end) {
        end = i;
      }
    }
    return end == 0;
  }
}
