package com.mapei.javatest.test_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/12/21
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.incrementAndGet()); //11
        int i1 = atomicInteger.get(); //11
        boolean result1 = atomicInteger.compareAndSet(i1, 20);
        System.out.println(result1 + "  " + atomicInteger.get() + "   " + i1); //20
        boolean result2 = atomicInteger.compareAndSet(11, 30);
        System.out.println(result2 + "  " + atomicInteger.get()); //20

        System.out.println(atomicInteger.updateAndGet(x -> {
//            atomicInteger.decrementAndGet(); //如果加上这行代码，lambda表达式死循环
            if (x % 2 == 0){
                return 0;
            }
            else {
                return 1;
            }
        })); //17
    }
}
