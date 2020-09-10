package com.github.mgljava.basicstudy.leetcode;


public class Palindrome {

  public static void main(String[] args) {
    boolean palindrome = new Palindrome().isPalindrome("race a car");
    System.out.println(palindrome);
  }

  public boolean isPalindrome(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetterOrDigit(s.charAt(i))) {
        stringBuilder.append(Character.toLowerCase(s.charAt(i)));
      }
    }
    return stringBuilder.toString().equals(stringBuilder.reverse().toString());
  }
}
