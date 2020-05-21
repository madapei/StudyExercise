package com.mapei.javatest.test_thread;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/5/20
 */
public class RecursiveTaskTest {
    public static void main(String[] args) {
        /*int start1 = (int) TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        MyRecursiveTask task = new MyRecursiveTask(0, 100000000);
        task.fork();

        System.out.println(task.join());
        int end1 = (int) TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        System.out.println((end1 - start1));*/

        int start2 = (int) TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        int result = 0;
        for (int i = 0; i < 100000000; i++){
            result += i;
        }
        int end2 = (int) TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        System.out.println(result + " - " + (end2 - start2));
    }
}

class MyRecursiveTask extends RecursiveTask<Integer>{
    private int start;
    private int end;

    public MyRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < 10){
            int result = 0;
            for (int i = start; i < end; i++){
                result += i;
            }
            return result;
        }
        else {
            int mid = (start + end)/2;
            MyRecursiveTask task1 = new MyRecursiveTask(start, mid);
            MyRecursiveTask task2 = new MyRecursiveTask(mid, end);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
