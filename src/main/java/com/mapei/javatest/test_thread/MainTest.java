package com.mapei.javatest.test_thread;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/8/5
 */
public class MainTest {
    public static void main(String[] args) {
        LockTest test1 = new LockTest(200, 300);
        LockTest test2 = new LockTest(100, 200);
        Runnable r1 = () -> {
            test1.doSomething();
        };
        Runnable r2 = () -> {
            test2.doSomething();
        };
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
    }
}

class LockTest{
    private int initCount;
    private int doCount;
    private Lock lock;
    private Condition condition;
    public LockTest(int initCount, int doCount){
        this.doCount = doCount;
        this.initCount = initCount;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void doSomething(){
        lock.lock();
        try {
            while (initCount < doCount){
                System.out.println(Thread.currentThread().getName() + "----- initCount < doCount -----");
                condition.await();
            }
            System.out.println("----- begin initCount: " + initCount + " -----");
            initCount -= doCount;
            System.out.println("----- after initCount: " + initCount + " -----");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
