package com.test;

import java.util.concurrent.atomic.AtomicBoolean;

public class WaitNotify {

    public static void main(String[] args) {
        Object lock = new Object();
        AtomicBoolean isOldRun = new AtomicBoolean(true);

        PrintOldValue printOldValue = new PrintOldValue(lock, isOldRun);
        PrintEvenValue printEvenValue = new PrintEvenValue(lock, isOldRun);
        Thread thread1 = new Thread(printOldValue);
        Thread thread2 =  new Thread(printEvenValue);

        thread1.start();
        thread2.start();
    }

}

class PrintOldValue implements Runnable {
    private Object lock;
    private AtomicBoolean isOldRun;

    public PrintOldValue(Object lock, AtomicBoolean isOldRun) {
        this.isOldRun = isOldRun;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 1) {
                    if (!isOldRun.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Old : " + i);
                    isOldRun.set(false);
                    try {
                        lock.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class PrintEvenValue implements Runnable {

    private Object lock;
    private AtomicBoolean isOldRun;

    public PrintEvenValue(Object lock, AtomicBoolean isOldRun) {
        this.isOldRun = isOldRun;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    if (isOldRun.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even: " + i);
                    isOldRun.set(true);
                    try {
                        lock.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}