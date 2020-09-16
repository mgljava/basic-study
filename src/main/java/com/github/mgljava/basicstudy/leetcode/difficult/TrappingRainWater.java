package com.github.mgljava.basicstudy.leetcode.difficult;

public class TrappingRainWater {

  public static void main(String[] args) {
    int trap = new TrappingRainWater().trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println(trap);
  }

  public int trap(int[] height) {
    int ans = 0;
    int size = height.length;
    for (int i = 0; i < size - 1; i++) {
      int maxLeft = 0;
      int maxRight = 0;
      for (int j = i; j >= 0; j--) {
        maxLeft = Math.max(maxLeft, height[j]);
      }
      for (int j = i; j < size; j++) {
        maxRight = Math.max(maxRight, height[j]);
      }
      ans += Math.min(maxLeft, maxRight) - height[i];
    }
    return ans;
  }
}
