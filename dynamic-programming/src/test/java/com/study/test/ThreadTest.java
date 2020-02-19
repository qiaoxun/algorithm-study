package com.study.test;

public class ThreadTest {
    public static void main(String[] args) {
        new ThreadA().start();
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadA");
    }
}
