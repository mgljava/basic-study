package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class ClosestPointsOrigin973 {

  public static void main(String[] args) {
    new ClosestPointsOrigin973().kClosest(new int[][] {{1, 3}, {-2, 2}}, 1);
  }

  public int[][] kClosest(int[][] points, int K) {
    if (K >= points.length) {
      return points;
    }
    Arrays.sort(points, Comparator.comparingInt(p -> (p[0] * p[0] + p[1] * p[1])));
    return Arrays.copyOfRange(points, 0, K);
  }

  public int[][] kClosest1(int[][] points, int K) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

    for (int i = 0; i < K; i++) {
      queue.offer(new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
    }

    int n = points.length;
    for (int i = K; i < n; i++) {
      int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
      assert queue.peek() != null;
      if (dist < queue.peek()[0]) {
        queue.poll();
        queue.offer(new int[] {dist, i});
      }
    }

    int[][] ans = new int[K][2];
    for (int i = 0; i < K; i++) {
      ans[i] = points[Objects.requireNonNull(queue.poll())[1]];
    }
    return ans;
  }
}
