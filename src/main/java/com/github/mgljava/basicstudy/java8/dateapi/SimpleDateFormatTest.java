package com.github.mgljava.basicstudy.java8.dateapi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author：Monk
 * date：2018年9月11日22:26:07
 * desc：原始的SimpleDateFormat存在线程安全问题
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = () -> simpleDateFormat.parse("20180911");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<Date>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futureList.add(executorService.submit(task));
        }
        for (Future<Date> future : futureList) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
