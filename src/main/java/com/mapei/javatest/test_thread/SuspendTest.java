package com.mapei.javatest.test_thread;

import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/1/8
 */
public class SuspendTest {
    private static int count;

    private static volatile boolean suspendFlag;

    public static void main(String[] args) throws InterruptedException{
        SuspendTest test = new SuspendTest();
        test.mySuspendTest();
    }

    private static void normalSuspendTest() throws InterruptedException{
        Runnable r = () -> {
            System.out.println("------ start runnning -----");
            while (true){
                System.out.println(count++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(3000);
        t.suspend();
        System.out.println("******* suspend ********");
        Thread.sleep(3000);
        t.resume();
        System.out.println("******* resume *********");
    }

    private void mySuspendTest() throws InterruptedException{
        suspendFlag = true;
        Runnable r = () -> {
            System.out.println("------ start runnning -----");
            while (true){
                try {
                    synchronized (this){
                        while (!suspendFlag){
                            wait();
                        }
                    }

                    System.out.println(count++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();

        Thread.sleep(3000);
        mySuspend();
        System.out.println("******* suspend ********");
        Thread.sleep(3000);
        myResume();
        System.out.println("******* resume *********");
    }

    private void mySuspend(){
        suspendFlag = false;
    }

    private synchronized void myResume(){
        notifyAll();
        suspendFlag = true;
    }
}
