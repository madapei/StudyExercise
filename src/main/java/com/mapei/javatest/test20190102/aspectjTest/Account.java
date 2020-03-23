package com.mapei.javatest.test20190102.aspectjTest;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/3
 */
public class Account {
    int balance = 20;

    public boolean pay(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
