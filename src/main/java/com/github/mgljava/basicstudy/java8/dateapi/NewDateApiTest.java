package com.github.mgljava.basicstudy.java8.dateapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author：Monk
 * date：2018年9月11日22:34:04
 * desc：Java8提供的日期时间API
 */
public class NewDateApiTest {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = () -> LocalDate.parse("20180911", dateTimeFormatter);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futureList.add(executorService.submit(task));
        }
        for (Future<LocalDate> future : futureList) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
