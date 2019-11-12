package com.github.mgljava.basicstudy;

public class CaesarCipherTest {

  public static void main(String[] args) {
    /*System.out.print(symbol('l', 1));
    System.out.print(symbol('o', 1));
    System.out.print(symbol('p', 1));
    System.out.print(symbol('o', 1));
    System.out.print(symbol('x', 1));*/
    System.out.println(decode("ijj tipvme ibwf lopxo uibu zpv xpvme ibwf b qfsgfdu botxfs gps nf !!!", 1));
    System.out.println(decode("opP DBQUBJO! nz Dbqubjo! pvs gfbsgvm usjq jt epof;", 1));
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
    return getChar(getNum(ch) - shift);
  }
}
