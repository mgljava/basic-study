package com.github.mgljava.basicstudy.java8.dateapi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NewApiTest {

  public static void main(String[] args) {

    Date date = new Date();
    System.out.println(date.toString());

    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
    System.out.println(localDate.plusYears(1));

    LocalTime localTime = LocalTime.now();
    System.out.println(localTime);

    LocalDate localDate1 = LocalDate.parse("2018-09-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    System.out.println(localDate1);
  }
}
