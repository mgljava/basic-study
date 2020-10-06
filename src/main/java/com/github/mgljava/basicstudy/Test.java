package com.github.mgljava.basicstudy;

public class Test {

  public static void main(String[] args) {
    int r = 0;
    for (int i = 0; ; i++) {
      if (i % 3 == 2 && i % 5 == 3 && i % 7 == 2) {
        r = i;
        break;
      }
    }
    System.out.println(r);
  }
}
