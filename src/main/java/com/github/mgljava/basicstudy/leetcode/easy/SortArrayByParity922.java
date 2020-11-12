package com.github.mgljava.basicstudy.leetcode.easy;

public class SortArrayByParity922 {

  public int[] sortArrayByParityII(int[] A) {
    int[] ans = new int[A.length];
    int index = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        ans[index] = A[i];
        index += 2;
      }
    }
    index = 1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 != 0) {
        ans[index] = A[i];
        index += 2;
      }
    }
    return ans;
  }
}
