package com.github.mgljava.basicstudy.leetcode;

/**
 * <p>移动零</p>
 * <p>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
 * <p>
 * 解法1：找到所有为0和非零元素的数组，然后拼接两个数组
 * <br>
 * 解法2：引入变量j，将不为0的元素全部用j指针来赋值，最后将大于j指针的元素全部赋值为0
 */


public class MoveZero {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 0, 2, 3, 6, 0, 9, 43, 0, 2};
    new MoveZero().moveZeroes(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
    }
    while (j < nums.length) {
      nums[j++] = 0;
    }
  }
}
