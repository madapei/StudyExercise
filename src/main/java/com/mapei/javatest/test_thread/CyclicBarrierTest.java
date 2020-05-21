package com.mapei.javatest.test_thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/4/16
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("========================"));

        CyclicBarrier barrier = new CyclicBarrier(4, thread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <8; i++){
            executorService.execute(new Passenger(i, barrier));
        }

        executorService.shutdown();
    }
}

class Passenger implements Runnable{
    private int id;
    private CyclicBarrier barrier;

    public Passenger(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Passenger" + id + " has arrived!");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Passenger" + id + " gogooo!");
    }
}