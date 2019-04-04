package com.github.mgljava.basicstudy.forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

    @Test
    public void test1() {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinCalc = new ForkJoinCalc(1L, 10000L);
        Long invoke = pool.invoke(forkJoinCalc);

        System.out.println(invoke);
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();
        System.out.println(sum);
        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start));
    }
}
