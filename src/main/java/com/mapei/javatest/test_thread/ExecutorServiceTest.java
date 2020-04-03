package com.mapei.javatest.test_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/24
 */
public class ExecutorServiceTest {
    public static void main(String[] args) throws Exception{
        submitRunnable();
        submitRunnableWithResult();
        submitCallable();
    }

    public static void submitRunnable() throws Exception{
        Runnable r = () -> {
            System.out.println("Hello! submitRunnable");
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        Future future = pool.submit(r);
        System.out.println("submitRunnable: " + future.get());
    }

    public static void submitRunnableWithResult() throws Exception{
        Runnable r = () -> {
            System.out.println("Hello! submitRunnableWithResult");
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> future = pool.submit(r, 1);
        System.out.println("submitRunnableWithResult: " + future.get());
    }

    public static void submitCallable() throws Exception{
        Callable<Integer> callable = () -> {
            System.out.println("Hello! submitCallable");
            return 2;
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> future = pool.submit(callable);
        System.out.println("submitCallable: " + future.get());
    }
}


