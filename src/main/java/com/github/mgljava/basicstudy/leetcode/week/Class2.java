package com.github.mgljava.basicstudy.leetcode.week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Class2 {

  public static void main(String[] args) {
    List<Boolean> class2 = new Class2()
        .checkArithmeticSubarrays(new int[] {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[] {0,1,6,4,8,7}, new int[] {4,4,9,7,9,10});
    System.out.println(class2);
  }

  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    if (l.length != r.length) {
      return new ArrayList<>();
    }
    List<List<Integer>> par = new ArrayList<>();
    for (int i = 0; i < l.length; i++) {
      ArrayList<Integer> integers = new ArrayList<>();
      integers.add(l[i]);
      integers.add(r[i]);
      par.add(integers);
    }
    List<Boolean> ans = new ArrayList<>();
    for (List<Integer> list : par) {
      List<Integer> ss = new ArrayList<>();
      for (int s = list.get(0); s <= list.get(1); s++) {
        ss.add(nums[s]);
      }
      Collections.sort(ss);
      ans.add(isTrue(ss));
    }
    return ans;
  }

  public boolean isTrue(List<Integer> ss) {
    if (ss.size() < 2) {
      return false;
    }
    for (int i = 2; i < ss.size(); i++) {
      if (ss.get(i) - ss.get(i - 1) != ss.get(1) - ss.get(0)) {
        return false;
      }
    }
    return true;
  }
}
