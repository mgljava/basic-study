package com.github.mgljava.basicstudy.leetcode.middle;

public class NumberOfIslands200 {

  public static void main(String[] args) {
    NumberOfIslands200 numberOfIslands200 = new NumberOfIslands200();
    char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
    System.out.println(numberOfIslands200.numIslands(grid));
  }

  // 使用深度优先搜索算法
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int nr = grid.length; // 行数
    int nc = grid[0].length; // 列数

    int sum = 0;
    for (int r = 0; r < nr; r++) {
      for (int c = 0; c < nc; c++) {
        if (grid[r][c] == '1') {
          sum++;
          dfs(grid, r, c);
        }
      }
    }
    return sum;
  }

  private void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;
    // 边界条件
    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }
    grid[r][c] = '0';
    // 遍历上下左右并赋值为0
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }
}
