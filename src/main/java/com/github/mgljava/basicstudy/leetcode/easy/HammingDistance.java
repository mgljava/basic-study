package com.github.mgljava.basicstudy.leetcode.easy;

public class HammingDistance {

  public static void main(String[] args) {
    int i = new HammingDistance().hammingDistance(7, 4);
    System.out.println(i);
  }

  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
  }
}
