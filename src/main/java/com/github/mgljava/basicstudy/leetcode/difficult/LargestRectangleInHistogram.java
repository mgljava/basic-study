package com.github.mgljava.basicstudy.leetcode.difficult;

/**
 * 柱状图中最大的矩形
 * <br>
 *   解法1：暴力
 *   解法2：stack
 */

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    // int i = new LargestRectangleInHistogram().largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3});
    int i = new LargestRectangleInHistogram().largestRectangleArea(new int[] {2,1,2});
    System.out.println(i);
  }

  public int largestRectangleArea(int[] heights) {
    if (heights.length == 1) {
      return heights[0];
    }
    int max = 0;
    for (int i = 0; i < heights.length - 1; i++) {
      int min = Math.min(heights[i], heights[i + 1]);
      int area;
      if (min == 0) {
        area = Math.abs(heights[i] - heights[i + 1]);
      } else {
        area = min * 2;
      }
      max = Math.max(area, max);

    }
    return max;
  }
}
