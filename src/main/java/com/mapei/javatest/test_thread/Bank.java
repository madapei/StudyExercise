package com.mapei.javatest.test_thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/11/12
 */
public class Bank {
    private final double[] accounts;

    private Lock lock;

    private Condition suffientFunds;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        lock = new ReentrantLock();
        suffientFunds = lock.newCondition();
    }

    public void transfer(int from, int to, double amount){
        lock.lock();
        try {
            while (accounts[from] < amount) {
                System.out.println("-------------------------------------");
                suffientFunds.await();
            }
            System.out.print(Thread.currentThread() + "     ");
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("    from(" + accounts[from] + ")   to(" + accounts[to] + ")");
            System.out.printf("    Total Balance:%10.2f%n", getTotalBalance());

            suffientFunds.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
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
