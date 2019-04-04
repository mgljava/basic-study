package com.github.mgljava.basicstudy.java8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

public class ConsumerTest {

    // 对传入的参数进行消费。无返回值
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void testConsumer() {
        happy(100D, (m) -> System.out.println("今天消费:" + m));
    }

}
