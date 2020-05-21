package com.mapei.javatest.test_thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/5/19
 */
public class HockThread {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("======== over =======")));
        System.out.println("-------------- start ----------------");
        Thread t1 = new Thread(() -> {
            while (true){
                System.out.println("ddd");
                sleep(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                System.out.println("t" + i);
                sleep(1);
            }
        });

        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println("-------------- end ----------------");
    }

    private static void sleep(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
