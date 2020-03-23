package com.mapei.javatest.test_thread;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/1/8
 */
public class StopTest {
    private volatile boolean flag;
    public static void main(String[] args) throws InterruptedException{
        StopTest test = new StopTest();
        test.start();
        System.out.println("************* start ************");
        Thread.sleep(1000 * 5);
        test.stop();
        System.out.println("************* stop ************");
    }

    public void test() {
        Runnable r = () -> {
            System.out.println("-------- start running --------");
            int i = 0;
            while (flag){
                System.out.println(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    public void stop(){
        this.flag = false;
    }

    public void start(){
        this.flag = true;
        test();
    }
}
