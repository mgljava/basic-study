package com.github.mgljava.basicstudy.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionOps {

  public static void main(String[] args) {
    // 普通Collection的创建
    List<String> list = Lists.newArrayList();
    Set<String> stringSet = Sets.newHashSet();
    Map<String, Object> objectMap = Maps.newHashMap();

    /**
     * 不可变的对象 1.在多线程操作下，是线程安全的。 2.所有不可变集合会比可变集合更有效的利用资源。 3.中途不可改变
     */
    // 不变Collection的创建
    ImmutableList<String> stringImmutableList = ImmutableList.of("a", "b", "c");
    ImmutableSet set = ImmutableSet.of("e1", "e2");
    ImmutableMap map = ImmutableMap.of("k1", "v1", "k2", "v2");

    // 一个map中包含key为String value为List类型的时候 以前我们是这样写的
    Map<String, List<Integer>> stringListHashMap = new HashMap<String, List<Integer>>();
    List<Integer> integerArrayList = new ArrayList<>();
    integerArrayList.add(1);
    integerArrayList.add(2);
    stringListHashMap.put("aa", integerArrayList);
    System.out.println(stringListHashMap.get("aa"));//[1, 2]

    /**
     * 现在的写法
     */
    Multimap<String, Integer> multimap = ArrayListMultimap.create();
    multimap.put("aa", 1);
    multimap.put("aa", 2);
    System.out.println(multimap.get("aa"));  //[1, 2]

    List<String> stringList = new ArrayList<>();
    stringList.add("aa");
    stringList.add("bb");
    stringList.add("cc");
    String result = Joiner.on("-").join(stringList);
    System.out.println(result);

    Map<String, Integer> stringIntegerMap = Maps.newHashMap();
    stringIntegerMap.put("zhangsan", 12);
    stringIntegerMap.put("lisi", 20);
    Joiner.on(",").withKeyValueSeparator("=").join(map);

    String str = "1-2-3-4-5-6";
    List<String> splitToList = Splitter.on("-").splitToList(str); // [1, 2, 3, 4, 5, 6]

    // 将String转换为map
    String s = "xiaoming=11,xiaohong=23";
    Map<String, String> stringStringMap = Splitter.on(",").withKeyValueSeparator("=").split(s);

  }
}
