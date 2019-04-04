package com.github.mgljava.basicstudy.java8.dateapi;

import java.time.Duration;
import java.time.Instant;

public class Test {

  public static void main(String[] args) {

    /*// 用now方法获取当前日期
    LocalDate today = LocalDate.now();
    System.out.println("Current Date=" + today);
    // 通过指定的参数来创建实例
    LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
    System.out.println("Specific Date=" + firstDay_2014);
    // 根据时区来创建
    LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Shanghai"));
    System.out.println("Current Date in CTT=" + todayKolkata);
    // 在01/01/1970基础上加365天
    LocalDate dateFromBase = LocalDate.ofEpochDay(365);
    System.out.println("365th day from base date= " + dateFromBase);
    // 2014年后的100天
    LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
    System.out.println("100th day of 2014=" + hundredDay2014);

    LocalTime time = LocalTime.now();
    System.out.println("Current Time=" + time);

    LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
    System.out.println("Specific Time of Day=" + specificTime);

    LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
    System.out.println("Current Time in IST=" + timeKolkata);

    LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
    System.out.println("10000th second time= " + specificSecondTime);*/

    /*LocalDateTime today = LocalDateTime.now();
    System.out.println("Current DateTime=" + today);

    today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    System.out.println("Current DateTime=" + today);

    LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
    System.out.println("Specific Date=" + specificDate);

    LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    System.out.println("Current Date in IST=" + todayKolkata);

    LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
    System.out.println("10000th second time from 01/01/1970= " + dateFromBase);*/

    /*Instant timestamp = Instant.now();
    System.out.println("Current Timestamp = " + timestamp);

    Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
    System.out.println("Specific Time = " + specificTime);

    Duration thirtyDay = Duration.ofDays(30);
    System.out.println(thirtyDay);*/


  }
}
