package com.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class WaitNotify {

    public static void main(String[] args) {

        AtomicBoolean isOldRun = new AtomicBoolean(true);
        Thread thread2 = null;
        Thread thread1 = null;

        thread1 = new Thread(new PrintOldValue(thread2, isOldRun));
        thread2 =  new Thread(new PrintEvenValue(thread1, isOldRun));

        thread1.start();
        thread2.start();
    }

}

class PrintOldValue implements Runnable {
    private Thread otherThread;
    private AtomicBoolean isOldRun;

    public PrintOldValue(Thread otherThread, AtomicBoolean isOldRun) {
        this.otherThread = otherThread;
        this.isOldRun = isOldRun;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println("PrintOldValue " + isOldRun.get());
                if (!isOldRun.get()) {
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                isOldRun.set(false);
                try {
                    otherThread.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class PrintEvenValue implements Runnable {

    private Thread otherThread;
    private AtomicBoolean isOldRun;

    public PrintEvenValue(Thread otherThread, AtomicBoolean isOldRun) {
        this.otherThread = otherThread;
        this.isOldRun = isOldRun;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                if (isOldRun.get()) {
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                isOldRun.set(true);
                try {
                    otherThread.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
}