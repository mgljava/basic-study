package com.github.mgljava.basicstudy.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

// 消费消息
public class Consumer {

  public static void main(String[] args) throws Exception {
    // 实例化消费者
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group");
    // 设置NameServer的地址
    consumer.setNamesrvAddr("127.0.0.1");
    // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
    consumer.subscribe("syncTopic", "*");
    // 注册回调实现类来处理从broker拉取回来的消息
    consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
      System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
      // 标记该消息已经被成功消费
      return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    });
    // 启动消费者实例
    consumer.start();
    System.out.printf("Consumer Started.%n");
  }
}
