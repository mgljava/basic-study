package com.github.mgljava.basicstudy.rocketmq.producer;

import java.util.ArrayList;
import java.util.List;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 批量消息
 */
public class BatchMessageProducer {

  public static void main(String[] args) throws Exception {

    DefaultMQProducer producer = new DefaultMQProducer("BatchProducer");
    producer.setNamesrvAddr("127.0.0.1:9876");
    producer.start();

    String topic = "BatchProducerTopic";
    List<Message> messages = new ArrayList<>();

    messages.add(new Message(topic, "TagA", "OrderID001", "Hello world 1".getBytes()));
    messages.add(new Message(topic, "TagA", "OrderID002", "Hello world 2".getBytes()));
    messages.add(new Message(topic, "TagA", "OrderID003", "Hello world 3".getBytes()));

    try {
      producer.send(messages);
    } catch (Exception e) {
      e.printStackTrace();
    }
    producer.shutdown();
  }
}
