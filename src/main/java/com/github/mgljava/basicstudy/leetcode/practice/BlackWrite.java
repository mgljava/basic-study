package com.github.mgljava.basicstudy.leetcode.practice;

public class BlackWrite {

  public int findLonelyPixel(char[][] picture) {
    int s = 0;
    int e = 0;
    int ans = 0;
    char b = 'B';
    for (int i = s; i < picture.length; i++) {
      int count = 0;
      for (int j = e; j < picture[i].length; j++) {
        if (picture[i][j] == b) {
          count++;
        }
      }
    }
    return ans;
  }
}
