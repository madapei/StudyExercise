package com.mapei.javatest.test20190322;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/22
 */
public class MainTestFirst {
   /* public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 0; i < 50; i++){
                System.out.println("------" + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(run);

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    System.out.println("------" + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
        thread1.start();

    }*/

    public static void main(String[] args) {
        String test = test();
        test.trim();
        System.out.println("'" + test + "'");
    }

    public static String test(){
        return " Hello World! ";
    }
}
