package com.github.mgljava.basicstudy.java8.dateapi;

import org.junit.Test;

import java.time.*;
import java.util.Set;

public class LocalDateTimeTest {

  /**
   * DateTimeFormatter：格式化时间和日期
   * ZonedDate, ZonedTime, ZonedDateTime
   */
  @Test
  public void test7() {
    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    System.out.println(availableZoneIds);

    LocalDateTime now = LocalDateTime.now(ZoneId.of("Australia/Eucla"));
    System.out.println(now);
  }

  /**
   * Duration : 计算两个时间的间隔 Period：计算两个日期之间的间隔
   * TemporalAdjuster：校正器
   * TemporalAdjusters：提供了校正器的相关的静态方法
   */
  @Test
  public void test3() throws Exception {
    Instant now = Instant.now();
    Thread.sleep(2000);
    Instant now1 = Instant.now();
    Duration between = Duration.between(now, now1);
    System.out.println(between);
    System.out.println(between.toNanos());

    System.out.println("--------------------------");

  }

  /**
   * Instant 时间戳：以Unix元年：1970.01.01.00.00.00--> 时间的毫秒值
   */
  @Test
  public void test2() {
    Instant now = Instant.now(); // 获取的是 UTC 时区
    System.out.println(now);

    OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
    System.out.println(offsetDateTime);

    System.out.println(now.toEpochMilli());
  }


  /**
   * LocalDate LocalTime LocalDateTime
   */
  @Test
  public void test1() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    LocalDateTime of = LocalDateTime.of(2018, 10, 12, 10, 20, 32);
    System.out.println(of);

    LocalDateTime localDateTime = now.plusYears(2);
    System.out.println(localDateTime);

    LocalDateTime localDateTime1 = localDateTime.minusYears(1);
    System.out.println(localDateTime1);
  }
}
