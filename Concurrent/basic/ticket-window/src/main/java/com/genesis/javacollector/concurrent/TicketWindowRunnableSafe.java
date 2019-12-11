package com.genesis.javacollector.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : KG
 * description:
 * create date: 3:44 PM 2019/12/11
 * modified by:
 */

public class TicketWindowRunnableSafe implements Runnable {

    private static AtomicInteger index = new AtomicInteger(0);

    private static final int MAX = 50;

    @Override
    public void run() {
        Thread.currentThread().setName(Thread.currentThread().getName().replace("pool-1-thread-", "服务窗口"));
        while (index.intValue() < MAX) {
            System.out.println(Thread.currentThread() + " 的号码是: " + index.getAndIncrement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
