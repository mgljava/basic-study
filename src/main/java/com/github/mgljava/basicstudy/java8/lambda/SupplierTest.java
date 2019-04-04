package com.github.mgljava.basicstudy.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {

    // 产生一些整数，并放入到集合当中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }


    @Test
    public void testSupplier() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }
}
