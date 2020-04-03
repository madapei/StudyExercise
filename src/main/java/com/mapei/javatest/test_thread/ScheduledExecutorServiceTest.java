package com.mapei.javatest.test_thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/24
 */
public class ScheduledExecutorServiceTest {
    private static int i = 0;
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println(i++);
        };

        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        pool.scheduleAtFixedRate(r1, 0, 1, TimeUnit.SECONDS);
    }
}
