package com.github.mgljava.basicstudy.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionDefaultTest_1 {

  private String homeAddress = "homeAddress"; // 成员变量
  private static String companyAddress = "companyAddress"; // 静态变量
  void test() {
    int age = 30;
    FunctionDefaultTest functionDefaultTest = name -> "name is : " + name + " age is " + age +
        " homeAddress is " + homeAddress +
        " companyAddress is " + companyAddress;
    System.out.println(functionDefaultTest.sayHello("zhangsan"));

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println(integer);
      }
    });
    // 简化写法
    numbers.forEach((Integer number) -> System.out.println(number));
    // 简化写法(省略类型的声明，编译器根据上下文自动推断)
    numbers.forEach(number -> System.out.println(number));
    // 更简化写法 方法引用
    numbers.forEach(System.out::println);
    System.out.println("---------------------------");

    Function<String, Integer> convertToString = new Function<String, Integer>() {
      @Override
      public Integer apply(String s) {
        return Integer.valueOf(s);
      }
    };
   // convertToString.apply("1233x"); // 报错，包含字符不能转为Integer

    Function<String, Integer> toInteger = Integer::valueOf;
    final Integer apply = toInteger.apply("123");
    System.out.println(apply);

    System.out.println("---------------------------");

    Predicate<Integer> predicate = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer == 1;
      }
    };
    System.out.println(predicate.test(1)); // true
    System.out.println(predicate.test(2)); // false

    // 简化写法
    Predicate<Integer> predicate2 = integer -> integer == 1;
    System.out.println(predicate2.test(1)); // true
    System.out.println(predicate2.test(2)); // false

    Stream.of();
  }

  public static void main(String[] args) {
    new FunctionDefaultTest_1().test();
  }
}
