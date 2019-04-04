package com.github.mgljava.basicstudy.java8.lambda;

import org.junit.Test;

public class MyFunctionInterfaceTest {

    public Integer opsInteger(Integer number, MyFunctionInterface myFunctionInterface) {
        return myFunctionInterface.getValue(number);
    }

    @Test
    public void testAdd() {
        System.out.println(opsInteger(100, (x) -> x + 20));
    }

    @Test
    public void testMut() {
        System.out.println(opsInteger(6, (x) -> x * x));
    }

    public void opsLong(Long l1, Long l2, MyFunctionInterface2<Long, Long> m) {
        System.out.println(m.getValue(l1, l2));
    }

    @Test
    public void test3() {
        opsLong(100L, 200L, (l1, l2) -> l1 + l2);
    }
}
