package com.github.mgljava.basicstudy.java8.stream;

import static com.github.mgljava.basicstudy.java8.lambda.Employee.Status.BUSY;
import static com.github.mgljava.basicstudy.java8.lambda.Employee.Status.FREE;
import static com.github.mgljava.basicstudy.java8.lambda.Employee.Status.VOCATION;

import com.github.mgljava.basicstudy.java8.lambda.Employee;
import com.github.mgljava.basicstudy.java8.lambda.Employee.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class StreamAPITest2 {

    List<Employee> employees = Arrays.asList(
            new Employee(10, "zhangsan", 30, 3000),
            new Employee(20, "lisi", 20, 5000),
            new Employee(16, "wangwu", 22, 3600),
            new Employee(30, "zhaoliu", 60, 9000)
    );

    /**
     * 筛选和切片 filter -> 接收Lambda，从流中排除某些元素 limit -> 截断流，使其元素不超过给定数量 skip(n) -> 跳过流，跳过给定的 n 个元素 distinct ->
     * 去重（筛选），通过流的Hashcode()和equals()方法去除重复元素。注意：重写该两个方法
     **/
    @Test
    public void test11() {
        employees.stream().filter(employee -> employee.getAge() > 20)
                .forEach(System.out::println);
    }

    /**
     * map: 将元素进行映射，接收一个函数作为参数，该函数会被应用到每个元素上 flatMap: 将接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test12() {

    }

    /**
     * 排序 sorted: 自然排序 (Comparable) sorted(Comparator com): 定制排序
     */
    @Test
    public void test13() {
        List<String> words = Arrays.asList("aa", "cc", "bd", "ee", "ab");
        words.stream().sorted().forEach(System.out::println);

        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
    }

    /**
     * 查找和匹配 规约： reduce(T identity, BinaryOperator)
     */
    @Test
    public void test14() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        System.out.println("---------------------------------");

        Double reduce1 = employees.stream()
                .map(Employee::getSalary)
                .reduce(0d, (x, y) -> x + y);
        System.out.println(reduce1);

        System.out.println("---------------------------------");
        Optional<Double> reduce2 = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce2.get());
    }

    /**
     * 收集器：Collector（接口） Collectors 实现类，提供了多种静态方法
     */
    @Test
    public void test15() {

        // toList
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // toCollection
        HashSet<String> collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect);

        // joining
        String collect1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect1);

        // summarizingDouble
        DoubleSummaryStatistics collect2 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect2.getMax());
        System.out.println(collect2.getMin());
    }

    /**
     * 多级分组 groupingBy 分区：partitionBy
     */
    @Test
    public void test16() {
        Map<String, Map<Integer, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName,
                        Collectors.groupingBy(Employee::getAge)));
        System.out.println(collect);

        Map<Boolean, List<Employee>> collect1 = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(collect1);
    }


    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, BUSY),
            new Employee(101, "张三", 18, 9999.99, FREE),
            new Employee(103, "王五", 28, 3333.33, VOCATION),
            new Employee(104, "赵六", 8, 7777.77, BUSY),
            new Employee(104, "赵六", 8, 7777.77, FREE),
            new Employee(104, "赵六", 8, 7777.77, FREE),
            new Employee(105, "田七", 38, 5555.55, BUSY)
    );

    //3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }

    //需求：搜索名字中 “六” 出现的次数
    @Test
    public void test2() {
        Optional<Integer> sum = emps.stream()
                .map(Employee::getName)
                .flatMap(StreamAPITest2::filterCharacter)
                .map((ch) -> {
                    if (ch.equals('六')) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).reduce(Integer::sum);

        System.out.println(sum.get());
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test3() {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        HashSet<String> hs = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void test4() {
        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println(op.get());

        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println(sum);

        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avg);

        Long count = emps.stream()
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");

        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
    }

    //分组
    @Test
    public void test5() {
        Map<Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    //多级分组
    @Test
    public void test6() {
        Map<Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60) {
                        return "老年";
                    } else if (e.getAge() >= 35) {
                        return "中年";
                    } else {
                        return "成年";
                    }
                })));

        System.out.println(map);
    }

    //分区
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

        System.out.println(map);
    }

    //
    @Test
    public void test8() {
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "----", "----"));

        System.out.println(str);
    }

    @Test
    public void test9() {
        Optional<Double> sum = emps.stream()
                .map(Employee::getSalary).reduce(Double::sum);

        System.out.println(sum.get());
    }
}
