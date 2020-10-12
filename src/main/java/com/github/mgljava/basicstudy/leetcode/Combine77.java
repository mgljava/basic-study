package com.github.mgljava.basicstudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>输入: n = 4, k = 2</p>
 * <p>
 * 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * </p>
 */
public class Combine77 {


  public static void main(String[] args) {
    List<List<Integer>> combine = new Combine77().combine(4, 2);
    System.out.println(combine);
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    this.backTrace(lists, list, n, k, 1);
    return lists;
  }

  public void backTrace(List<List<Integer>> res, List<Integer> list, int n, int k, int begin) {
    if (k > n) {
      return;
    }
    if (k == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = begin; i <= n; i++) {
      list.add(i);
      backTrace(res, list, n, k - 1, i + 1);
      // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
      list.remove(list.size() - 1);
    }
  }
}
