package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.Arrays;

public class SquaresSortedArray977 {

  public static void main(String[] args) {
    int[] ints = new SquaresSortedArray977().sortedSquares3(new int[] {-7, -3, 2, 3, 11});
    for (int i : ints) {
      System.out.println(i);
    }
  }

  public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = A[i] * A[i];
    }
    Arrays.sort(A);
    return A;
  }

  /**
   * 双指针 + 归并排序
   */
  public int[] sortedSquares1(int[] A) {
    int n = A.length;
    int negative = -1;
    for (int i = 0; i < n; i++) {
      if (A[i] < 0) {
        negative = i;
      }
    }
    int[] ans = new int[n];
    int index = 0;
    int i = negative; // 负数部分
    int j = negative + 1; // 非负数部分
    while (i >= 0 || j < n) {
      if (i < 0) {
        ans[index] = A[j] * A[j];
        j++;
      } else if (j == n) {
        ans[index] = A[i] * A[i];
        i--;
      } else if (A[i] * A[i] < A[j] * A[j]) {
        ans[index] = A[i] * A[i];
        i--;
      } else {
        ans[index] = A[j] * A[j];
        i++;
      }
      index++;
    }
    return ans;
  }

  /**
   * 双指针, 一个指针指向0,另一个指针指向n-1；每次比较两个指针的值进行插入
   */
  public int[] sortedSquares3(int[] A) {
    int low = 0;
    int n = A.length;
    int hi = n - 1;
    int[] ans = new int[n];
    int index = 0;
    while (low <= hi) {
      if (Math.abs(A[low]) < Math.abs(A[hi])) {
        ans[index] = A[low] * A[low];
        low++;
      } else {
        ans[index] = A[hi] * A[hi];
        hi--;
      }
      index++;
    }
    Arrays.sort(ans);
    return ans;
  }
}
