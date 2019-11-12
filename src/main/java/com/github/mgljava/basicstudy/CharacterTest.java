package com.github.mgljava.basicstudy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterTest {

  public static void main(String[] args) {
    // System.out.println(encode("mer", 6015));
    String str = "1024ugki";
    /*String decode = decode(str);
    if (str.equals(encode(decode, decodeNum(str)))){
      System.out.println("decode");
    } else {
      System.out.println("error");
    }*/
  // System.out.println(decode("5057aan"));
   System.out.println(encode("mer", 6015));
  }

  public static Double multiply(Double a, Double b) {
    return a * b;
  }

  public static String encode(String string, int number) {
    char[] chars = string.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(number);
    for (char ch : chars) {
      int encode = getNum(ch) * number % 26;
      stringBuilder.append(getChar(encode));
    }
    return stringBuilder.toString();
  }

  public static String decode(String str) {
    int number = decodeNum(str);
    String encodeString = decodeString(str);
    StringBuilder a = new StringBuilder();
    for (char ch : encodeString.toCharArray()) {
      for (int i = 1; i < 26; i++) {
        if (i * number % 26 == getNum(ch)) {
          a.append(getChar(i));
          break;
        }
      }
    }
    return a.toString();
  }

  // 6015
  public static int decodeNum(String str) {
    String regEx = "[^0-9]";
    Pattern p = Pattern.compile(regEx);
    Matcher m = p.matcher(str);
    return Integer.parseInt(m.replaceAll(""));
  }

  // ekx
  public static String decodeString(String str) {
    String s = "" + decodeNum(str) + "";
    return str.substring(s.length());
  }

  public static int getNum(char str) {
    return (int) str - 96;
  }

  public static char getChar(int number) {
    return (char) (number + 96);
  }
}
