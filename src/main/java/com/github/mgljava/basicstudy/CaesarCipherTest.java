package com.github.mgljava.basicstudy;

public class CaesarCipherTest {

  public static void main(String[] args) {
    // String[] code = {"ijJ tipvme ibw", "f lopxo uibu z", "pv xpvme ibwf ", "b qfsgfdu botx", "fs gps nf!!!"};
    String[] code = {"opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;"};
    String decode = decode(code, 1);
    System.out.println(decode);
  }

  public static int getNum(char str) {
    return (int) str - 97;
  }

  public static char getChar(int number) {
    return (char) (number + 97);
  }

  public static String decode(String[] string, final int shift) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String s : string) {
      stringBuilder.append(s);
    }
    String result = stringBuilder.toString();
    String wei = result.substring(result.indexOf(" "));
    stringBuilder = new StringBuilder();
    for (char ch : wei.toCharArray()) {
      stringBuilder.append(symbol(ch, shift));
    }
    return result.charAt(0) + stringBuilder.toString();
  }

  public static char symbol(char ch, int shift) {
    if (ch > 'z' || ch < 'A')
      return ch;
    return getChar(getNum(ch) - shift);
  }
}
