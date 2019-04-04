package com.github.mgljava.basicstudy.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    // 将满足条件的字符串提取出来，加入到集合中
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> returnLists = new ArrayList<>();

        for (String string : list) {
            if (predicate.test(string)) {
                returnLists.add(string);
            }
        }

        return returnLists;
    }

    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("hello", "php", "world", "hadoop", "java");
        List<String> strings = filterString(list, (x) -> x.length() >= 5);
        System.out.println(strings);
    }
}
