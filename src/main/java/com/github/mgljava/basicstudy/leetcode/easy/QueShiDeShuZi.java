package com.github.mgljava.basicstudy.leetcode.easy;

public class QueShiDeShuZi {

  public static void main(String[] args) {
    int i = new QueShiDeShuZi().missingNumber(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 10});
    System.out.println(i);
  }

  public int missingNumber(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == mid) {
        left = mid + 1;
      } else if (nums[mid] > mid) {
        right = mid - 1;
      }
    }
    return left;
  }
}
