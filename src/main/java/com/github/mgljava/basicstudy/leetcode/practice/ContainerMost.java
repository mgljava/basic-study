package com.github.mgljava.basicstudy.leetcode.practice;

public class ContainerMost {

  public static void main(String[] args) {
    System.out.println(new ContainerMost().maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  public int maxArea(int[] height) {
    int max = 0;
    for (int i = 0, j = height.length - 1; i < j; ) {
      int minHeight;
      if (height[i] >= height[j]) {
        minHeight = height[j];
        j--;
      } else {
        minHeight = height[i];
        i++;
      }
      int area = minHeight * (j - i + 1); // 加1的原因是由于先前进行了i、j的加减
      max = Math.max(area, max);
    }
    return max;
  }
}
