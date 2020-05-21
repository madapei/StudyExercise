package com.mapei.javatest.test_thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/4/22
 */
public class AQS_Test {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            test();
        }, "T1").start();
        new Thread(() -> {
            test();
        }, "T2").start();
        new Thread(() -> {
            test();
        }, "T3").start();
    }

    private static void test(){
        lock.lock();
        System.out.println("thread name : " + Thread.currentThread());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
