package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;

public class RemoveString3 {

  public static void main(String[] args) {
    int[] list = new int[] {1, 1, 2, 2, 3, 5, 5, 5, 5, 7, 7, 7, 8, 9};
    System.out.println(remove(list));
    Arrays.stream(list).forEach(System.out::println);
  }

  private static int remove(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
