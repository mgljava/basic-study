package com.github.mgljava.basicstudy.leetcode.practice;

public class ValidMountainArray {

  public static void main(String[] args) {
    boolean b = new ValidMountainArray().validMountainArray(new int[] {3, 4, 5, 6, 7, 8});
    System.out.println(b);
  }

  public boolean validMountainArray(int[] A) {
    if (A.length < 3) {
      return false;
    }
    int left = 0;
    int right = A.length - 1;
    while (left < A.length - 1 && A[left] < A[left + 1]) {
      left++;
    }
    while (right > 0 && A[right] < A[right - 1]) {
      right--;
    }
    return left == right && left != 0 && right != A.length - 1;
  }
}
