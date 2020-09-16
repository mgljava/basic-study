package com.github.mgljava.basicstudy.leetcode.difficult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SparseSimilarityLcci {

  public static void main(String[] args) {
    int[][] nums = {{1, 5, 3}, {1, 7, 2, 3}};
    List<String> strings = new SparseSimilarityLcci().computeSimilarities(nums);
    System.out.println(strings);
  }

  public List<String> computeSimilarities(int[][] docs) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int i = 0; i < docs.length; i++) {
      for (int j = 0; j < docs[i].length; j++) {
        set1.add(i);
      }
    }
    System.out.println("set1: " + set1);
    System.out.println("set2: " + set2);
    return null;
  }
}
