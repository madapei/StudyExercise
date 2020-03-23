package com.mapei.javatest.test_thread;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/12/21
 */
public class VolatileTest {
    private static int i = 0, j = 0;

    public static void main(String[] args) {

        Runnable r1 = () -> {
            while (true){
                one();
            }

        };

        Runnable r2 = () -> {
            while (true){
                two();
            }

        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    public static void one(){
        i++;
        j++;
    }
    public static void two(){
        System.out.println( i + "-" + j);
    }
}
