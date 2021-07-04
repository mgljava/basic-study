package com.github.mgljava.basicstudy.leetcode.easy;

public class ErFen704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] params = new int[] {-1, 0, 3, 5, 9, 12};
        int search = new ErFen704().search(params, 9);
        System.out.println(search);
    }
}
