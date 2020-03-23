package com.mapei.javatest.test20190218;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/2/18
 */
public class Outer {
    static class Inner{
        {
            System.out.println("Inner class!");
        }
    }

    public void test(String[] args) {
        Inner i = new Inner();
    }
}
