package com.github.mgljava.basicstudy.rocketmq.consumer;

import static com.github.mgljava.basicstudy.rocketmq.Constants.NAME_SRV;

import java.util.List;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

public class BatchMessageConsumer {

  public static void main(String[] args) throws Exception {

    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("BatchConsumer");
    consumer.setNamesrvAddr(NAME_SRV);
    consumer.subscribe("BatchProducerTopic", "*");

    consumer.registerMessageListener(new MessageListenerConcurrently() {
      @Override
      public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt messageExt : msgs) {
          System.out.println("keys:" + messageExt.getKeys() +", body:" + new String(messageExt.getBody()));
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
      }
    });
    consumer.start();
  }
}
