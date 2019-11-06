package com.github.mgljava.basicstudy.rocketmq.consumer;

import java.util.List;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

public class DelayMessageConsumer {

  public static void main(String[] args) throws Exception {
    // 实例化消费者
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("DelayConsumer");
    consumer.setNamesrvAddr("127.0.0.1:9876");
    // 订阅Topics
    consumer.subscribe("delayTestTopic", "*");
    // 注册消息监听者
    consumer.registerMessageListener(new MessageListenerConcurrently() {
      @Override
      public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext context) {
        for (MessageExt message : messages) {
          // Print approximate delay time period
          System.out.println(
              "Receive message[msgId=" + message.getMsgId() + "] " + (System.currentTimeMillis() - message.getStoreTimestamp()) + "ms later");
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
      }
    });
    // 启动消费者
    consumer.start();
  }
}
