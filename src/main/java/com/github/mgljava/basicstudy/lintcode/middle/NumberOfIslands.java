package com.github.mgljava.basicstudy.lintcode.middle;

// 利用深度优先搜索算法实现，将搜索到的1全部置为0
public class NumberOfIslands {

  public static void main(String[] args) {
    NumberOfIslands numberOfIslands200 = new NumberOfIslands();
    boolean[][] grid = {
        {true, true, false, false, false},
        {false, true, false, false, true},
        {false, false, false, true, true},
        {false, false, false, false, false},
        {false, false, false, false, true}
    };
    System.out.println(numberOfIslands200.numIslands(grid));
  }

  public int numIslands(boolean[][] grid) {
    if (grid == null) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int sum = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j]) {
          sum++;
          dfs(grid, i, j);
        }
      }
    }
    return sum;
  }

  private void dfs(boolean[][] grid, int row, int column) {
    int newRow = grid.length;
    int newColumn = grid[0].length;

    if (row < 0 || column < 0 || row >= newRow || column >= newColumn || grid[row][column]) {
      return;
    }
    grid[row][column] = false;
    dfs(grid, row - 1, column);
    dfs(grid, row + 1, column);
    dfs(grid, row, column - 1);
    dfs(grid, row, column + 1);
  }
}
