package com.mapei.javatest.test_thread;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/8/13
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thread name:" + t.getName());
    }
}
