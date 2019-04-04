package com.github.mgljava.basicstudy.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest1 {

    @Test
    public void test1() {
        // 1.
        List<String> list = new ArrayList<>();
        list.stream();

        // 2.
        Arrays.stream(new String[100]);

        // 3.
        Stream.of("aa", "bb");

        // 4.1
        Stream.iterate(0, (x) -> x + 2)
                .limit(10)
                .forEach(System.out::println);

        // 4.2
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
