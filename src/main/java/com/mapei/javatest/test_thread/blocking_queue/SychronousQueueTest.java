package com.mapei.javatest.test_thread.blocking_queue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/6/4
 */
public class SychronousQueueTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread producer = new Thread(() -> {
            atomicInteger.set(666);
            System.out.println("producet " + atomicInteger.get());
            sleep(3);
            countDownLatch.countDown();
        }, "T1");

        Thread consumer = new Thread(() -> {
            System.out.println("----- start concumer -----");
            try {
                countDownLatch.await();
                System.out.println("consum " + atomicInteger.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2");
        producer.start();
        consumer.start();
    }

    public static void test2(){
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("---- start producer ----");
                sleep(3);
                synchronousQueue.put(666);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() ->{
            try {
                System.out.println("---- start consumer ----");
                Integer result = synchronousQueue.take();
                System.out.println("consumer " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
    }

    private static void sleep(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
