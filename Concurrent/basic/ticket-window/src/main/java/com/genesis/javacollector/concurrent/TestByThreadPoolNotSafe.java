package com.genesis.javacollector.concurrent;

import java.util.concurrent.*;

/**
 * @author : KG
 * description:
 * create date: 4:16 PM 2019/12/11
 * modified by:
 */

public class TestByThreadPoolNotSafe {
    public static void start() {
        Runnable task = new TicketWindowRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.shutdown();
    }
}
