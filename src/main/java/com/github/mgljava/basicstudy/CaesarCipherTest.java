package com.github.mgljava.basicstudy;

public class CaesarCipherTest {

  public static void main(String[] args) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] code = {"ijJ tipvme ibw", "f lopxo uibu z", "pv xpvme ibwf ", "b qfsgfdu botx", "fs gps nf!!!"};
    // String[] code = {"opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;"};
    for (String s : code) {
      stringBuilder.append(s);
    }
    String result = stringBuilder.toString();
    String substring = result.substring(0, result.indexOf(" "));
    String wei = result.substring(result.indexOf(" "));
    String decode = decode(wei, substring.charAt(1) - substring.charAt(0));
    System.out.println(substring.charAt(0) + decode);
  }

  public static int getNum(char str) {
    return (int) str - 97;
  }

  public static char getChar(int number) {
    return (char) (number + 97);
  }

  public static String decode(String string, final int shift) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char ch : string.toCharArray()) {
      stringBuilder.append(symbol(ch, shift));
    }
    return stringBuilder.toString();
  }

  public static char symbol(char ch, int shift) {
    if (ch > 'z' || ch < 'A')
      return ch;
    return getChar(getNum(ch) - shift);
  }
}
