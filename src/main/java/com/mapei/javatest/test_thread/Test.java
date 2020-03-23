package com.mapei.javatest.test_thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/11/6
 */
public class Test {
    public static void main(String[] args) {
        Runnable r = () -> {
            new ReentrantLock().newCondition().signalAll();
            System.out.println("************ start run ************");
            while (true){
                int i = 0;
                int j = 1/i;
            }
        };

        Thread.UncaughtExceptionHandler handler = (t, e) ->{
            System.out.println("Thread name: " + t.getName() + ", e.getMessage= " + e.getMessage());
        };


        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(handler);
        thread.start();

    }
}
