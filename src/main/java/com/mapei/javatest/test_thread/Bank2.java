package com.mapei.javatest.test_thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/11/21
 */
public class Bank2 {
    private final double[] accounts;

    public Bank2(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount){
        try {
            while (accounts[from] < amount) {
                wait();
            }
            System.out.print(Thread.currentThread() + "     ");
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("    from(" + accounts[from] + ")   to(" + accounts[to] + ")");
            System.out.printf("    Total Balance:%10.2f%n", getTotalBalance());

            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
//            lock.unlock();
        }
    }

    public double getTotalBalance(){
        double sum = 0;
        for (double a : accounts){
            sum += a;
        }
        return sum;
    }



    public int size(){
        return accounts.length;
    }
}
