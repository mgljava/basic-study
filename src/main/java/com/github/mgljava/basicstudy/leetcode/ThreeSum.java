package com.github.mgljava.basicstudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    // int[] nums = new int[] {0, 0, 0, 0};
    System.out.println(new ThreeSum().tree(nums));
  }

  // 双指针
  public List<List<Integer>> tree(int[] nums) {
    // 排序
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    // 只需要计算到length-2个元素
    for (int i = 0; i < nums.length - 2; i++) {
      // 排好序的数组中，如果当前数据大于0，则不需要往后遍历了
      if (nums[i] > 0) {
        return res;
      }
      // 如果num[i]==num[i-1] 直接跳过，避免重重复
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int curr = nums[i];
      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        // sum
        int sum = curr + nums[l] + nums[r];
        if (sum == 0) {
          // 记录值
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l + 1] == nums[l]) {
            // 判断下一个是不是和当前相等
            ++l;
          }
          while (l < r && nums[r - 1] == nums[r]) {
            --r;
          }
          ++l;
          --r;
        } else if (sum < 0) {
          // 小于0  左边 ++
          l++;
        } else {
          // 大于0 右边 --
          r--;
        }
      }
    }
    return res;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return res;
  }
}
