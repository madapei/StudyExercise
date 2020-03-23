package com.mapei.javatest.test_thread;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/12
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10, 0);
        int initStamp = atomicStampedReference.getStamp();
        Integer initRefer = atomicStampedReference.getReference();
        System.out.println("初始版本号：" + initStamp + ", 初始值：" + initRefer);

        Thread t1 = new Thread(() ->{
            boolean result = atomicStampedReference.compareAndSet(initRefer, initRefer, initStamp, initStamp + 1);
            if (result){
                System.out.println(Thread.currentThread().getName() + " Set Success! 版本号：" + atomicStampedReference.getStamp() + ", 值：" + atomicStampedReference.getReference());
            }
            else {
                System.out.println(Thread.currentThread().getName() + " Set Failed! 版本号：" + atomicStampedReference.getStamp() + ", 值：" + atomicStampedReference.getReference());
            }
            result = atomicStampedReference.compareAndSet(initRefer, initRefer, initStamp + 1, initStamp);
            if (result){
                System.out.println(Thread.currentThread().getName() + " Set Success! 版本号：" + atomicStampedReference.getStamp() + ", 值：" + atomicStampedReference.getReference());
            }
        });

        Thread t2 = new Thread(() -> {
            boolean result = atomicStampedReference.compareAndSet(initRefer, initRefer + 4, initStamp, initStamp + 1);
            if (result){
                System.out.println(Thread.currentThread().getName() + " Set Success! 版本号：" + atomicStampedReference.getStamp() + ", 值：" + atomicStampedReference.getReference());
            }
            else {
                System.out.println(Thread.currentThread().getName() + " Set Failed! 版本号：" + atomicStampedReference.getStamp() + ", 值：" + atomicStampedReference.getReference());
            }
        });
        try {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("版本号：" + atomicStampedReference.getStamp() + ", 值：" + atomicStampedReference.getReference());
    }
}
