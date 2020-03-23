package com.mapei.javatest.test20190102.aspectjTest;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/3
 */
public class AspectjMainTest {
    public static void main(String[] args) {
        testCompileTime();
    }
    public static void testCompileTime() {
        Account account = new Account();
        System.out.println("==================");
        account.pay(10);
        account.pay(50);
        System.out.println("==================");
    }
}
