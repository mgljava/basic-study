package com.github.mgljava.basicstudy.leetcode.middle;

public class ErChaSousuoShu {

  public static void main(String[] args) {
    boolean b = new ErChaSousuoShu().verifyPostorder(new int[] {1,2,5,10,6,9,4,3});
    System.out.println(b);
  }
  // 1,3,2,6,5
  public boolean verifyPostorder(int[] postorder) {
    int root = Integer.MIN_VALUE;
    for (int i = postorder.length - 1; i >= 0; i--) {
      if (postorder[i] < postorder[i - 1]) {
        root = postorder[i];
        break;
      }
    }
    int index = 0;
    for (int i = 0; i < postorder.length - 1; i++) {
      if (postorder[i] >= root) {
        index = i;
        break;
      }
    }
    for (int i = index; i < postorder.length - 1; i++) {
      if (postorder[i] <= root) {
        return false;
      }
    }
    return true;
  }
}
