package com.github.mgljava.basicstudy.java8.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * 函数型接口.
 */
public class FunctionTest {

    // 用于处理字符串
    public String dealStringHandler(String sourceString, Function<String, String> function) {
        return function.apply(sourceString);
    }

    @Test
    public void testFunction() {
        System.out.println(dealStringHandler("hello", (x) -> x.toUpperCase()));
    }

    @Test
    public void testFunction2() {
        System.out.println(dealStringHandler("helloworld", x -> x.substring(5)));
    }
}
