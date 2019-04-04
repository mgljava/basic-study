package com.github.mgljava.basicstudy.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DishTest {

  public static void main(String[] args) {

    List<Dish> menus = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH));

    // 获取菜品的名字
    menus.stream()
        .map(Dish::getName)
        // 给所有的元素执行一个打印的动作
        .forEach(System.out::println);
    System.out.println("-------------------");
    // 打印菜品的卡路里
    menus.stream()
        .forEachOrdered(dish -> System.out.println(dish.getCalories()));
    System.out.println("-------------------");
    final Object[] objects = menus.stream()
        .toArray();
    System.out.println(objects);
    System.out.println("-------------------");
    menus.stream()
        .filter(Dish::isVegetarian)
        .collect(Collectors.toList());
    // 获取所有菜品的名字，并且去掉重复的
    menus.stream()
        .map(Dish::getName)
        .distinct()
        .collect(Collectors.toList());

    // 取得前3个菜品
    menus.stream()
        .limit(3)
        .collect(Collectors.toList());

    // 扔掉前三个菜品
    menus.stream()
        .skip(3)
        .collect(Collectors.toList());

    // 你将如何利用流来筛选前两个荤菜呢？
    menus.stream()
        .filter(dish -> dish.getType() == Dish.Type.MEAT)
        .limit(2)
        .collect(Collectors.toList());
    ;

    /*List<Stream<String>> collect = words
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());*/

    // 流的扁平化
    // 对于一张单词表,如何返回一张列表，列出里面各不相同的字符呢？
    String[] arrayOfWords = {"Goodbye", "World", "Hadoop", "Spark", "Park"};
    Stream<String> words = Arrays.stream(arrayOfWords);
    List<String> collect1 = words
        .map(word -> word.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .collect(Collectors.toList());
    System.out.println(collect1);

    // 菜单里面是否有素食可选择
    menus.stream()
        .anyMatch(Dish::isVegetarian);

    // 所有菜的热量都低于1000卡路里
    menus.stream()
        .allMatch(dish -> dish.getCalories() <= 1000);

    // 没有任何菜的热量大于1000卡路里
    menus.stream()
        .noneMatch(dish -> dish.getCalories() > 1000);

    // 返回素食流中的任意一个元素
    menus.stream()
        .map(Dish::isVegetarian)
        .findAny();
    // 返回素食流中的第一个元素
    menus.stream()
        .map(Dish::isVegetarian)
        .findFirst();

    List<Integer> numbers = Arrays.asList(2, 4, 5, 6, 9);
    // reduce求和
    final Integer integer = numbers.stream()
        // 接收两个参数，第一个参数是一个初始值，另一个参数是一个二元运算符
        .reduce(0, (a, b) -> a + b);
    System.out.println(integer);

    // reduce求最大值
    final Integer reduce = numbers.stream()
        .reduce(0, Integer::max);
    System.out.println(reduce);

    final Optional<Integer> reduce1 = numbers.stream()
        .reduce(Integer::min);
    System.out.println(reduce1.get());

    // sorted：按照卡路里进行；排序
    menus.stream()
        .sorted(Comparator.comparingInt(Dish::getCalories))
        .forEach(System.out::println);

    System.out.println("*********************");

    // 获取卡路里最小的菜品
    final Optional<Dish> min = menus.stream()
        .min((o1, o2) -> Integer.min(o1.getCalories(), o2.getCalories()));
    System.out.println(min.get());

    System.out.println("*********************");

    // 获取卡路里最大的菜品
    final Optional<Dish> max = menus.stream()
        .max((o1, o2) -> Integer.max(o1.getCalories(), o2.getCalories()));
    System.out.println(max.get());

    System.out.println("*********************");

    // 统计菜品
    final long count = menus.stream()
        // 过滤
        .filter(Dish::isVegetarian)
        // 对过滤后的结果进行统计
        .count();
    System.out.println(count);

    System.out.println("*********************");

    // 改变流元素的内容
    menus.stream()
        .filter(Dish::isVegetarian)
        .peek(dish -> dish.setName("Beijing")).collect(Collectors.toList())
        .forEach(System.out::println);

    System.out.println("*********************");

    menus.stream()
        .filter(Dish::isVegetarian)
        .map(dish -> {
          dish.setName("Beijing");
          return dish;
        }).collect(Collectors.toList())
        .forEach(System.out::println);
    System.out.println("*********************");

    // 并行获取菜单名字
    menus.stream()
        .parallel()
        .map(Dish::getName)
        .forEach(System.out::println);

    // 转换为串行流
    menus.stream()
        .map(Dish::getName)
        .sequential()
        .forEach(System.out::println);

    final Dish next = menus.stream()
        .filter(Dish::isVegetarian)
        .iterator()
        .next();
    System.out.println(next.getName());
  }
}
