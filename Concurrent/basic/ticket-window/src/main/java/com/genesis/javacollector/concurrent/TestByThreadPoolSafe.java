package com.genesis.javacollector.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : KG
 * description:
 * create date: 4:16 PM 2019/12/11
 * modified by:
 */

public class TestByThreadPoolSafe {
    public static void start() {
        Runnable task = new TicketWindowRunnableSafe();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(task, "Window1");
        executorService.submit(task, "Window2");
        executorService.submit(task, "Window3");
        executorService.submit(task, "Window4");
        executorService.shutdown();
    }
}
