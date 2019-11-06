package com.github.mgljava.basicstudy.rocketmq.consumer;

import static com.github.mgljava.basicstudy.rocketmq.Constants.NAME_SRV;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

public class FilterMessageConsumer {

  public static void main(String[] args) throws Exception {
    // 实例化消费者
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("FilterMessageConsumer");
    // 设置NameServer的地址
    consumer.setNamesrvAddr(NAME_SRV);
    // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
    consumer.subscribe("FilterMessageProducerTopic", MessageSelector.bySql("a between 0 and 3"));
    // 注册回调实现类来处理从broker拉取回来的消息
    consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
      for (MessageExt messageExt : msgs) {
        System.out.println("keys:" + messageExt.getKeys() +", body:" + new String(messageExt.getBody()));
      }
      // 标记该消息已经被成功消费
      return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    });
    // 启动消费者实例
    consumer.start();
    System.out.printf("Consumer Started.%n");
  }
}
