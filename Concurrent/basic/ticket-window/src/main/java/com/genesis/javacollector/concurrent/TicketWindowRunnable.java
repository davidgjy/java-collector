package com.genesis.javacollector.concurrent;

/**
 * @author : KG
 * description:
 * create date: 3:44 PM 2019/12/11
 * modified by:
 */

public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private static final int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是: " + (index++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
