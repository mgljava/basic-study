package com.github.mgljava.basicstudy.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class Test1 {

  public static void main(String[] args) {

    // 新来的
    List<C1> c1s = new ArrayList<>();
    c1s.add(new C1("aa", "11"));
    c1s.add(new C1("bb", "22"));
    c1s.add(new C1("cc", "33"));
    c1s.add(new C1("dd", "33"));
    c1s.add(new C1("cc", "66"));

    // 现有的
    List<C2> c2s = new ArrayList<>();
    c2s.add(new C2("aa/11"));
    c2s.add(new C2("bb/22"));
    c2s.add(new C2("cc/33"));

    List<String> collect1 = c2s.stream().map(item -> item.getResult().substring(0, 2)).collect(Collectors.toList());
    List<String> collect2 = c2s.stream().map(item -> item.getResult().substring(3, 5)).collect(Collectors.toList());

    List<String> collect = c1s.stream()
        .filter(item -> !c2s.contains(new C2(item.getName() + "/" + item.getAge())))
        .filter(item -> !collect1.contains(item.getName()))
        .map(C1::getName)
        .collect(Collectors.toList());
    List<String> collect3 = c1s.stream()
        .filter(item -> !c2s.contains(new C2(item.getName() + "/" + item.getAge())))
        .filter(item -> !collect2.contains(item.getAge()))
        .map(C1::getAge)
        .collect(Collectors.toList());
    System.out.println(collect);
    System.out.println(collect3);

    String result = "abccd/2323";
    System.out.println(result.substring(0, result.indexOf("/")));
    System.out.println(result.substring(result.indexOf("/") + 1));

    Set<String> set1 = new HashSet<>();
    Set<String> set2 = new HashSet<>();

    set1.add("a");
    set1.add("b");
    set1.add("c");

    set2.add("c");
    set2.add("d");
    set2.add("e");

    //交集
    set1.removeAll(set2);

    System.out.println("交集是 "+set1);
  }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Dto {

  private List<String> names;
  private List<String> ages;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class C1 {

  private String name;
  private String age;
}

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
class C2 {

  private String result;
}
