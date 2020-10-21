package com.github.mgljava.basicstudy.leetcode.easy;

public class LongPressedName925 {

  public static void main(String[] args) {
    boolean longPressedName = new LongPressedName925().isLongPressedName("leelee", "lleeelee");
    System.out.println(longPressedName);
  }

  public boolean isLongPressedName(String name, String typed) {
    if (name.length() > typed.length()) {
      return false;
    }
    char[] names = name.toCharArray();
    char[] types = typed.toCharArray();
    int index = 0;
    int i = 0;
    while (index < types.length) {
      if (i<names.length && names[i] == types[index]) {
        i++;
        index++;
      } else if (index > 0 && types[index] == types[index - 1]) {
        index++;
      } else {
        return false;
      }
    }
    return i == names.length;
  }
}
