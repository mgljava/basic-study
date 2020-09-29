package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 电话号码的字母组合
public class CombinationsPhoneNumber17 {

  /*public static void main(String[] args) {
    List<String> strings = new CombinationsPhoneNumber17().letterCombinations("234");
    System.out.println(strings);
  }*/
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    backtrack(res, map, digits, 0, new StringBuilder());
    return res;
  }

  public void backtrack(List<String> res, Map<Character, String> map, String digits, int index, StringBuilder stringBuilder) {
    if (index == digits.length()) {
      res.add(stringBuilder.toString());
    } else {
      char c = digits.charAt(index);
      String s = map.get(c);
      for (int i = 0; i < s.length(); i++) {
        stringBuilder.append(s.charAt(i));
        backtrack(res, map, digits, index + 1, stringBuilder);
        stringBuilder.deleteCharAt(index);
      }
    }
  }

  static List<List<Integer>> ans = new ArrayList<>();

  public void back(List<Integer> res, int[] nums, int index) {
    if (index == nums.length) {
      ans.add(res);
    } else {
      res.add(nums[index]);
      back(res, nums, index + 1);
    }
  }

  public static void main(String[] args) {
    new CombinationsPhoneNumber17().back(new ArrayList<>(), new int[] {1, 2, 3}, 0);
    System.out.println(ans);
  }
}
