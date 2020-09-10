package com.github.mgljava.basicstudy.leetcode;

public class RemoveString2 {

  /*public static void main(String[] args) {
    int[] oldInt = {1,3,5,3,6,2,2,2,3,3,2,1,1,1,2,1,7};
    int[] newInt = RemoveString2.borderSort(oldInt);
    System.out.print("#:");
    for(int i = 0;i < newInt.length;i++){
      System.out.print(newInt[i] + " ");
    }
  }

  // 算法主体，去除相邻元素
  public static int[] borderSort(int[] sort) {

    // 定义两个游标,初始化为相邻游标
    int b = 0, a = 1;
    int len = sort.length;
    // 数组中 存在 -1 的个数
    int count = 0;
    while (a < len) {
      while (b >= 0 && a < len && sort[b] == sort[a]) {
        sort[b] = sort[a] = -1;
        while (b >= 0 && sort[b] == -1) {
          b--;
        }
        while (a < len && sort[a] == -1) {
          a++;
        }
        count = count + 2;
      }
      // 不满足则正常移动游标，都向前移动一个
      b = a++;
    }
    // 新数组，需要返回的数组
    int[] result = new int[len - count];
    // 新数组索引
    int newIndex = 0;
    for (int i = 0; i < len; i++) {
      if (sort[i] != -1) {
        result[newIndex] = sort[i];
        newIndex++;
      }
    }
    return result;
  }*/
  /*public static void main(String[] args) {
    String str = "aaabbbdsfduuerreerewww";
    String str2 = "abcdef";
    System.out.println(remove(str));
  }

  private static String remove(String str) {
    StringBuilder stringBuilder = new StringBuilder();

    *//*do {
      str =
    } while (str.length() > 1);*//*

    for (int i = 0; i < str.length() - 1; i++) {
      int p = i;
      int count = 0;
      while (str.charAt(p) == str.charAt(p + 1)) {
        p++;
      }

      do {
        i++;
        count++;
      } while (str.charAt(i--) == str.charAt(i));
      stringBuilder.append(str.charAt(i));
      if (count > 0) {
        stringBuilder.append(count + 1);
      }
    }
    return stringBuilder.toString();
  }

  private static String remove2(String str, int index) {
    return str.substring(0, index) + str.substring(index + 1);
  }*/

  public static void main(String[] args) {
    String str = "abeewwddcdddeeeerrrrrkk";
    StringBuilder stringBuilder = new StringBuilder();
    int count = 0;
    for (int i = 0; i < str.length() - 1; i++) {
      count++;
      if (str.charAt(i) != str.charAt(i + 1)) {
        stringBuilder.append(str.charAt(i));
        if (count > 1) {
          stringBuilder.append(count);
        }
        count = 0;
      }
    }
    stringBuilder.append(str.charAt(str.length() - 1));
    if (count > 0) {
      stringBuilder.append(count + 1);
    }
    System.out.println(stringBuilder.toString());
  }
}
