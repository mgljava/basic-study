package com.github.mgljava.basicstudy.java8.dateapi;

import java.time.Duration;
import java.time.Instant;

public class InstantTest {

  public static void main(String[] args) {

    final Instant instant = Instant.ofEpochSecond(20);
    System.out.println(instant);

    Duration duration = Duration.ofMinutes(3);
    System.out.println(duration);

  }
}
