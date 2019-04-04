package com.github.mgljava.basicstudy.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 有一个4长度的数组,每个位置装有0-9之间的随机数字,有10次输入的机会来猜每个位置的上的数是什么,
 * 每次猜完4个数字以后都要给出提示,正确几个,错误几个,只有位置和数字完全正确才算正确，其他情况全视为错误。
 */
public class GuessNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int[] consoleArray = new int[4];
    int[] randomArray = new int[4];
    // 将随机生成的数填充到数组中
    for (int i = 0; i < 4; i++) {
      randomArray[i] = random.nextInt(10);
    }

    // 输出数组的元素
    Arrays.stream(randomArray)
            .forEach(System.out::println);

    // 10次机会
    for (int i = 0; i < 10; i++) {
      // 接收用户输入的四个数字
      for (int j = 0; j < 4; j++) {
        consoleArray[j] = scanner.nextInt();
      }
      // 正确数字的个数，每次循环置为0
      int rightCount = 0;
      // 比较
      for (int k = 0; k < 4; k++) {
        if (randomArray[k] == consoleArray[k]) {
          rightCount++;
        }
      }
      if (4 == rightCount) {
        System.out.println("全部正确");
      } else {
        System.out.printf("正确：%d个，错误：%d个", rightCount, 4 - rightCount);
        System.out.println();
      }
    }
  }
}
