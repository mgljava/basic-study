package com.github.mgljava.basicstudy.java8.completeFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 实现异步API
 */
@Data
@AllArgsConstructor
public class Shop {

  private String shopName;

  /**
   * 同步方法
   */
  public double getPrice(String product) {
    return calculatePrice(product);
  }

  public String getPrice(String product, boolean api) {
    final double v = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
    return String.format("%s:%.2f:%s", "", v, code);
  }

  private double calculatePrice(String product) {
    delay();
    return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 异步方法
   */
  public Future<Double> getPriceAsync(String product) {
    // 创建CompletableFuture，包含计算的结果
    CompletableFuture<Double> completableFuture = new CompletableFuture<>();
    new Thread(() -> {
      try {
        // 在另一个线程中，线程中以异步方式执行计算
        double price = calculatePrice(product);
        completableFuture.complete(price);
      } catch (Exception ex) {
        ex.printStackTrace();
        completableFuture.completeExceptionally(new RuntimeException(ex.getMessage() + " 计算错误."));
      }
    }).start();
    // 无需等待还没结束的计算，直接返回Future对象
    return completableFuture;
  }
}
