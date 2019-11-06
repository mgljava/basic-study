package com.github.mgljava.basicstudy.rocketmq.producer;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送同步消息:可靠性同步地发送方式使用的比较广泛，比如：重要的消息通知，短信通知。
 */
public class SyncProducer {

  public static void main(String[] args) throws Exception {
    // 实例化消息生产者Producer
    DefaultMQProducer producer = new DefaultMQProducer("sync_producer_group");
    // 设置NameServer的地址
    producer.setNamesrvAddr("127.0.0.1:9876");
    // 启动Producer实例
    producer.start();

    for (int i = 0; i < 10; i++) {
      // 创建消息，并指定Topic，Tag和消息体
      Message message = new Message("topicTest", "syncTag", ("Hello RocketMQ " + i).getBytes(UTF_8));
      // 发送消息到一个Broker
      SendResult sendResult = producer.send(message);
      // 通过sendResult返回消息是否成功送达
      System.out.printf("%s%n", sendResult);
    }
    // 如果不再发送消息，关闭Producer实例。
    producer.shutdown();
  }
}
