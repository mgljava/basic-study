package com.github.mgljava.basicstudy.rocketmq.producer;

import static com.github.mgljava.basicstudy.rocketmq.Constants.NAME_SRV;
import static java.nio.charset.StandardCharsets.UTF_8;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 过滤消息
 */
public class FilterMessageProducer   {
  public static void main(String[] args) throws Exception {
    // 实例化消息生产者Producer
    DefaultMQProducer producer = new DefaultMQProducer("FilterMessageProducer");
    // 设置NameServer的地址
    producer.setNamesrvAddr(NAME_SRV);
    // 启动Producer实例
    producer.start();

    for (int i = 0; i < 10; i++) {
      // 创建消息，并指定Topic，Tag和消息体
      Message message = new Message("FilterMessageProducerTopic", "TagA", ("Hello RocketMQ " + i).getBytes(UTF_8));
      // 设置消息属性
      message.putUserProperty("a", String.valueOf(i));
      // 发送消息到一个Broker
      SendResult sendResult = producer.send(message);
      // 通过sendResult返回消息是否成功送达
      System.out.printf("%s%n", sendResult);
    }
    // 如果不再发送消息，关闭Producer实例。
    producer.shutdown();
  }
}
