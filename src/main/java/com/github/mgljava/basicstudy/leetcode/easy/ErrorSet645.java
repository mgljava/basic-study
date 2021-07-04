package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ErrorSet645 {

    public static void main(String[] args) {
        int[] params = new int[] {1, 2, 2, 4};
        int[] errorNums = new ErrorSet645().findErrorNums(params);
        for (int i : errorNums) {
            System.out.println(i);
        }
    }

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.get(i) != null) {
                result[0] = i;
                break;
            } else {
                map.put(i, i);
            }
        }
        result[1] = result[0] + 1;
        return result;
    }
}
