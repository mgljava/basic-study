package com.github.mgljava.basicstudy.java8.completeFuture;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 折扣服务，提供五个折扣服务，每个折扣服务对应一个折扣率
 */
public class Discount {

  @AllArgsConstructor
  public enum Code {
    NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
    private final int percentage;
  }
}
