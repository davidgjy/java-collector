package com.genesis.fundamental;

import com.genesis.fundamental.model.Order;
import java.util.concurrent.*;

/**
 * @author : KG
 * description:
 * create date: 1:42 PM 2019/12/5
 * modified by:
 */

public class TestMain {

    /**
     * 初始化延迟队列
     */
    private static DelayQueue<Order> queue = new DelayQueue<>();

    private static ExecutorService pool;

    public static void main(String[] args) throws InterruptedException {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        // 创建生产者线程
        pool.execute(new ProducerThread(20, queue));

        // 创建消费者线程
        pool.execute(new ConsumerThread(queue));
    }
}
