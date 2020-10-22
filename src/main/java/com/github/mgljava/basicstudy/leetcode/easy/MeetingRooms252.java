package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MeetingRooms252 {

  public static void main(String[] args) {
    int[][] nums = new int[][] {{0, 30}, {5, 10}, {15, 20}};
    int[][] nums1 = new int[][] {{7, 10}, {2, 4}};
    boolean b = new MeetingRooms252().canAttendMeetings(nums1);
    System.out.println(b);
  }

  // Map来解
  public boolean canAttendMeetings(int[][] intervals) {
    Map<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];
      for (int s = start; s < end; s++) {
        if (maps.get(s) != null) {
          return false;
        } else {
          maps.put(s, s);
        }
      }
    }
    return true;
  }

  // 通过比较两个数组看是否有冲突
  public boolean canAttendMeetings2(int[][] intervals) {
    for (int i = 0; i < intervals.length - 1; i++) {
      if (eq(intervals[i], intervals[i + 1])) {
        return false;
      }
    }
    return true;
  }

  private boolean eq(int[] i1, int[] i2) {
    return (i1[0] >= i2[0] && i1[0] < i2[1]) || (i2[0] >= i1[0] && i2[0] < i1[1]);
  }
}
