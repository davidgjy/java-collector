package com.genesis.fundamental;

import com.genesis.fundamental.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;

/**
 * @author : KG
 * description:
 * create date: 3:01 PM 2019/12/5
 * modified by:
 */

public class ConsumerThread implements Runnable {

    private DelayQueue<Order> queue;

    public ConsumerThread(DelayQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        consumer();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void consumer() {
        try {
            while (true) {
                Order order = queue.take();
                order.setStatus("已取消");
                System.out.println(String.format("时间：%s，订单：%s已过期", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), order.getOrderNo()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
