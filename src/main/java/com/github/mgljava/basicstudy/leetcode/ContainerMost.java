package com.github.mgljava.basicstudy.leetcode;

/**
 * 一维数组的坐标变换 i、j
 * <p>解法</p>
 * 1. 枚举：left、right
 * <br>
 * 2. 左右边界 i、j，向中间收敛
 */
public class ContainerMost {

  public static void main(String[] args) {
    System.out.println(new ContainerMost().maxArea2(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  // 双指针解法
  public int maxArea(int[] a) {
    int max = 0;
    for (int i = 0, j = a.length - 1; i < j; ) {
      int minHeight = a[i] < a[j] ? a[i++] : a[j--];
      int area = (j - i + 1) * minHeight;
      max = Math.max(max, area);
    }
    return max;
  }

  // 暴力解法
  public int maxArea2(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int area = (j - i) * Math.min(height[j], height[i]);
        max = Math.max(area, max);
      }
    }
    return max;
  }
}
