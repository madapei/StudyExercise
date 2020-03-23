package com.mapei.javatest.test_thread;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/11
 */
public class SynchronizedTest1{
    private static int i;

    public void test(){
        synchronized (this){
            i++;
        }
    }
}
