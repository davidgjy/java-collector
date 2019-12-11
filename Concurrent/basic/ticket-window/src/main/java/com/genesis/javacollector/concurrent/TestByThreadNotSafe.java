package com.genesis.javacollector.concurrent;

/**
 * @author : KG
 * description:
 * create date: 4:11 PM 2019/12/11
 * modified by:
 */

public class TestByThreadNotSafe {
    public static void start() {
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(task, "一号窗口");
        Thread windowThread2 = new Thread(task, "二号窗口");
        Thread windowThread3 = new Thread(task, "三号窗口");
        Thread windowThread4 = new Thread(task, "四号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
    }
}
