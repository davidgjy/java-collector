package com.genesis.fundamental;

import com.genesis.fundamental.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;

/**
 * @author : KG
 * description:
 * create date: 2:29 PM 2019/12/5
 * modified by:
 */

public class ProducerThread implements Runnable {

    private int num;
    private DelayQueue<Order> queue;

    public ProducerThread(int num, DelayQueue<Order> queue) {
        this.num = num;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= num; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer(queue, "O20191205" + i);
        }
    }

    private void producer(DelayQueue<Order> queue, String orderNo) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setStatus("待付款");
        order.setCreateTime(LocalDateTime.now());
        queue.add(order);
        System.out.println(String.format("时间：%s，订单：%s加入队列", order.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), order.getOrderNo()));
    }
}
