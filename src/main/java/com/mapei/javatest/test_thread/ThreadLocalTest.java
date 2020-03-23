package com.mapei.javatest.test_thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/1/6
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        //线面的例子演示了：通过ThreadLocal创建的对象是每个线程独有的
        /*Random random = new Random();
        ThreadLocal<Random> localRandom = ThreadLocal.withInitial(() -> new Random());

        for (int i = 0 ; i < 3; i++){
            Runnable r = () -> {
                System.out.println("-----Thread: " + Thread.currentThread().getName() + ", randomHashCode: " + random.hashCode());
                System.out.println("-----Thread: " + Thread.currentThread().getName() + ", threadLocalRandomHashCode1: " + localRandom.get().hashCode());
                System.out.println("-----Thread: " + Thread.currentThread().getName() + ", threadLocalRandomHashCode2: " + localRandom.get().hashCode());
            };
            Thread t = new Thread(r);
            t.start();
        }*/

        //下面的例子演示了SimpleDateFormat是线程不安全的
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0 ; i < 100; i++){
            Runnable r = () -> {
                try {
                    String date = "2019-01-06";
                    System.out.println("-----Thread: " + Thread.currentThread().getName() + ",String: " + date + ",  date1: " + format.parse(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }

    }
}
