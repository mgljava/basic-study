package com.github.mgljava.basicstudy.java8.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamTest2 {

  public static void main(String[] args) {

    // 1.  从1到100的连续正整数， 每两个相加并将结果list返回
    List<Integer> result1 = IntStream.range(1, 101)
        .filter(x -> x % 2 == 0)
        .mapToObj(item -> item += item - 1)
        .collect(toList());
    System.out.println(result1);

    // 2. 随机100个正整数，相邻每两个相加并将结果list返回
    final List<Integer> randomNumbers = IntStream.range(1, 101)
        .mapToObj(item -> new Random().nextInt(100) + 1)
        .collect(toList());
    List<Integer> result2 = IntStream.range(0, randomNumbers.size())
        .filter(x -> x % 2 == 0)
        .mapToObj(item -> randomNumbers.get(item) + randomNumbers.get(item + 1))
        .collect(toList());
    System.out.println(result2);
  }
}
