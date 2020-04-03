package com.mapei.javatest.test_thread;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/25
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        test3();
    }

    private static void test1(){
        Double[] numbers = new Double[10];
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println("---- start runAsync ----");
            for (int i = 0; i < numbers.length; i++){
                numbers[i] = Math.random();
            }
        });
        System.out.println("--------------------");
        future.whenComplete((t, u) -> {
            System.out.println("---- when complete ---- ");
            List<Double> list = Arrays.asList(numbers);
            long count = list.stream().filter(f -> f > 0.5).count();
            System.out.println("upper than 0.5 count: " + count);
        });
    }

    private static void test2(){
        Double[] numbers = new Double[10];
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("---- start runAsync ----");
            for (int i = 0; i < numbers.length; i++){
                numbers[i] = Math.random();
            }
            System.out.println(Arrays.asList(numbers).toString());
            return numbers[2];
        });
        System.out.println("--------------------");
        try {
            System.out.println("the third number : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void test3(){
        Double[] numbers = new Double[10];
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("---- start runAsync ----");
            for (int i = 0; i < numbers.length; i++){
                numbers[i] = Math.random();
            }
            System.out.println(Arrays.asList(numbers).toString());
            return numbers[1];
        });
        System.out.println("--------------------");
        future.thenAccept((r) -> {
            System.out.println("r : " + r);
            r = r * 2;
            System.out.println("after thenAccept : " + r);
        });
        CompletableFuture<Double> fresult = future.handle((s, Long) -> {
            System.out.println("s : " + s);
            s = s * 2;
            System.out.println("after handle : " + s);
            return s;
        });
        try {
            System.out.println("result : " + future.get());
            System.out.println("fresult : " + fresult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
