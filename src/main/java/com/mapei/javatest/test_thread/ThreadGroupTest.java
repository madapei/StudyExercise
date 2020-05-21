package com.mapei.javatest.test_thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/5/19
 */
public class ThreadGroupTest {
    private static volatile boolean flag = false ;
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("------ over ------")));

    }

    public static void test1(){
        Thread t1 = new Thread(() -> {
            System.out.println("--start t1--");
            int i = 0;
            while (true){
                synchronized (ThreadGroupTest.class){
                    if (i != 3 && !flag){
                        System.out.println("---t1-" + (i++) + "--");
                        sleep(1);
                    }
                    else if (i == 3 && !flag){
                        flag = true;
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println("--end t1--");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("--start t2--");
            int i = 0;
            while (true){
                synchronized (ThreadGroupTest.class){
                    if (i != 3 && !flag){
                        System.out.println("---t2-" + (i++) + "--");
                        sleep(1);
                    }
                    else if (i == 3 && !flag){
                        flag = true;
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println("--end t2--");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("--start t3--");
            int i = 0;
            while (true){
                synchronized (ThreadGroupTest.class){
                    if (i != 3 && !flag){
                        System.out.println("---t3-" + (i++) + "--");
                        sleep(1);
                    }
                    else if (i == 3 && !flag){
                        flag = true;
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println("--end t3--");
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public static void sleep(int i){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
