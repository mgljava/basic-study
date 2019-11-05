package com.github.mgljava.basicstudy.rocketmq.producer;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送异步消息:异步消息通常用在对响应时间敏感的业务场景，即发送端不能容忍长时间地等待Broker的响应。
 */
public class AsyncProducer {

  public static void main(String[] args) throws Exception {
    // 实例化消息生产者Producer
    DefaultMQProducer producer = new DefaultMQProducer("async_producer_group");
    // 设置NameServer的地址
    producer.setNamesrvAddr("127.0.0.1:9876");
    // 启动Producer实例
    producer.start();
    producer.setRetryTimesWhenSendAsyncFailed(0);

    for (int i = 0; i < 10; i++) {
      final int index = i;
      Message message = new Message("asyncTopic", "TagA", ("Hello RocketMQ " + i).getBytes(UTF_8));
      producer.send(message, new SendCallback() {
        @Override
        public void onSuccess(SendResult sendResult) {
          System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
        }

        @Override
        public void onException(Throwable e) {
          System.out.printf("%-10d Exception %s %n", index, e);
          e.printStackTrace();
        }
      });
    }

    // 如果不再发送消息，关闭Producer实例。
    producer.shutdown();
  }
}
