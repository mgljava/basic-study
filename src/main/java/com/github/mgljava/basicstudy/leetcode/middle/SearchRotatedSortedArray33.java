package com.github.mgljava.basicstudy.leetcode.middle;

public class SearchRotatedSortedArray33 {

  public static void main(String[] args) {
    int search = new SearchRotatedSortedArray33().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
    System.out.println(search);
  }

  public int search(int[] nums, int target) {
    int low = 0;
    int height = nums.length - 1;
    while (low < height) {
      int mid = (low + height) / 2;
      // 4 7
      if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
        low = mid + 1;
      } else if (target > nums[mid] && target < nums[0]) {
        low = mid + 1;
      } else {
        height = mid;
      }
    }
    return low == height && nums[low] == target ? low : -1;
  }
}
