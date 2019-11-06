package com.github.mgljava.basicstudy.rocketmq.producer;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

/**
 * Producer，发送顺序消息: 下面用订单进行分区有序的示例。 一个订单的顺序流程是：创建、付款、推送、完成。订单号相同的消息会被先后发送到同一个队列中，消费时，同一个OrderId获取到的肯定是同一个队列。
 */
public class OrderProducer {

  public static void main(String[] args) throws Exception {

    DefaultMQProducer producer = new DefaultMQProducer("order_producer_group");
    producer.setNamesrvAddr("127.0.0.1:9876");
    producer.start();

    String[] tags = new String[] {"TagA", "TagC", "TagD"};
// 订单列表
    List<OrderStep> orderList = new OrderProducer().buildOrders();
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateStr = sdf.format(date);
    for (int i = 0; i < 10; i++) {
      // 加个时间前缀
      String body = dateStr + " Hello RocketMQ " + orderList.get(i);
      Message msg = new Message("orderTopicTest", tags[i % tags.length], "KEY" + i, body.getBytes());

      SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
        @Override
        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
          Long id = (Long) arg;  //根据订单id选择发送queue
          long index = id % mqs.size();
          return mqs.get((int) index);
        }
      }, orderList.get(i).getOrderId());//订单id

      System.out.println(String.format("SendResult status:%s, queueId:%d, body:%s",
          sendResult.getSendStatus(),
          sendResult.getMessageQueue().getQueueId(),
          body));
    }

    producer.shutdown();
  }

  /**
   * 订单的步骤
   */
  @Data
  private static class OrderStep {

    private long orderId;
    private String desc;

    @Override
    public String toString() {
      return "OrderStep{" +
          "orderId=" + orderId +
          ", desc='" + desc + '\'' +
          '}';
    }
  }

  /**
   * 生成模拟订单数据
   */
  private List<OrderStep> buildOrders() {
    List<OrderStep> orderList = new ArrayList<>();

    OrderStep orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111039L);
    orderDemo.setDesc("创建");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111065L);
    orderDemo.setDesc("创建");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111039L);
    orderDemo.setDesc("付款");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103117235L);
    orderDemo.setDesc("创建");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111065L);
    orderDemo.setDesc("付款");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103117235L);
    orderDemo.setDesc("付款");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111065L);
    orderDemo.setDesc("完成");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111039L);
    orderDemo.setDesc("推送");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103117235L);
    orderDemo.setDesc("完成");
    orderList.add(orderDemo);

    orderDemo = new OrderStep();
    orderDemo.setOrderId(15103111039L);
    orderDemo.setDesc("完成");
    orderList.add(orderDemo);

    return orderList;
  }
}
