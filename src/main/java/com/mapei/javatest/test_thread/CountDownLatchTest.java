package com.mapei.javatest.test_thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/4/16
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 6; i++){
            executorService.execute(new Passengerc(i, latch));
        }
        System.out.println("-------------");
        try {
            latch.await();
            System.out.println("==============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class Passengerc implements Runnable{
    private int id;
    private CountDownLatch latch;

    public Passengerc(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public synchronized void run() {
//        try {
//            System.out.println("Passenger" + id + " has arrived!");
//            latch.await();
            System.out.println("Passenger" + id + " gogooo!" + latch.getCount());
//            latch.countDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}