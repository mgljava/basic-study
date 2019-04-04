package com.github.mgljava.basicstudy.java8.completeFuture;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompleteFutureTest {

  // 商店列表
  List<Shop> shops = Arrays.asList(
      new Shop("BestPrice"),
      new Shop("LetsSaveBig"),
      new Shop("MyFavoriteShop"),
      new Shop("BuyItAll"),
      new Shop("Fruit Shop"),
      new Shop("A"),
      new Shop("B"),
      new Shop("C"),
      new Shop("D"),
      new Shop("E"));

  public static void main(String[] args) {
    CompleteFutureTest beanTest = new CompleteFutureTest();
    long start = System.nanoTime();
    // System.out.println(beanTest.findPricesByBlock("iphone8"));
    // System.out.println(beanTest.findPricesByParallel("iphone8"));
    // System.out.println(beanTest.findPricesByCompletableFuture("iphone8"));
    System.out.println(beanTest.findPricesByCustomer("iphone8"));
    long duration = (System.nanoTime() - start) / 1_000_000;
    System.out.println("Done in " + duration + " msecs");
  }

  /**
   * 同步调用
   * 4个商家：Done in 4135 msecs
   * 5个商家：Done in 5148 msecs
   * 10个商家：Done in 10115 msecs
   */
  public List<String> findPricesByBlock(String product) {
    return shops.stream()
        .map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))
        .collect(toList());
  }

  /**
   * 改用并行流的方式，对多个商店进行并行调用：
   * 4个商家：Done in 1118 msecs
   * 5个商家：Done in 2121 msecs
   * 10个商家：Done in 3164 msecs
   */
  public List<String> findPricesByParallel(String product) {
    return shops.stream()
        .parallel()
        .map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))
        .collect(toList());
  }

  /**
   * 改用CompletableFuture进行异步调用
   */
  public List<String> findPricesByCompletableFuture(String product) {
    List<CompletableFuture<String>> priceFutures = shops.stream()
        // 使用CompletableFuture supplyAsync 以异步方式计算每种商品的价格
        .map(shop -> CompletableFuture.supplyAsync(() ->
            String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product))))
        .collect(toList());

    /**
     * 采用两个流的缘由：考虑流操作之间的延迟特性，如果你在单一流水线中处理流，
     * 发向不同商家的请求只能以同步、顺序执行的方式才会成功。
     * 4个商家：Done in 2198 msecs
     * 5个商家：Done in 2135 msecs
     * 10个商家：Done in 4193 msecs
     */
    return priceFutures.stream()
        // join 操作是为了等待他们运行结束
        .map(CompletableFuture::join)
        .collect(toList());
  }

  /**
   * 线程池大小计算：Nthreads = Ncpu * Ucpu * (1 + W/C)
   * 1.NCPU是处理器的核的数目，可以通过Runtime.getRuntime().availableProcessors()得到
   * 2.UCPU是期望的CPU利用率（该值应该介于0和1之间）
   * 3.W/C是等待时间与计算时间的比率
   * 使用定制的执行器
   * 当不大于100个商店时：执行时间都在1s重左右。
   */

  public List<String> findPricesByCustomer(String product) {

    // 自定义线程池
    final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
        runnable -> {
          Thread thread = new Thread(runnable);
          thread.setDaemon(true);
          return thread;
        });

    List<CompletableFuture<String>> priceFutures = shops.stream()
        // 使用CompletableFuture supplyAsync 以异步方式计算每种商品的价格
        .map(shop -> CompletableFuture.supplyAsync(() ->
            String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)), executor))
        .collect(toList());

    /**
     * 采用两个流的缘由：考虑流操作之间的延迟特性，如果你在单一流水线中处理流，
     * 发向不同商家的请求只能以同步、顺序执行的方式才会成功。
     * 10个商家：Done in 4193 msecs
     */
    return priceFutures.stream()
        // join 操作是为了等待他们运行结束
        .map(CompletableFuture::join)
        .collect(toList());
  }

}
