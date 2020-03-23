package com.mapei.javatest.test_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/11/22
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            Runnable r = () -> {
                ThreadLocal<SimpleDateFormat> local = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ"));
                String dateString = local.get().format(new Date());

//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
//                String dateString = format.format(new Date());
                for (int j = 0; j < 5; j++){
                    System.out.println("*********" + Thread.currentThread().getName() + "********" + dateString + "**********");
                }
                System.out.println();
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
