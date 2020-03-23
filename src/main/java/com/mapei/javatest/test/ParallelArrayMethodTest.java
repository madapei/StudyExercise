package com.mapei.javatest.test;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/13
 */
public class ParallelArrayMethodTest {
    public static void main(String[] args) {
        parallelSetAllTest();
    }

    public static void pallelSortTest(){
        int[] array = new int[10000000];
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(10000);
        }
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        System.out.println("---- normal sort time : " + endTime + "-" + startTime + "=" + (endTime - startTime));


        long startTime1 = System.nanoTime();
        Arrays.parallelSort(array);
        long endTime1 = System.nanoTime();
        System.out.println("---- parallel sort time : " + endTime1 + "-" + startTime1 + "=" + (endTime1 - startTime1));
    }

    public static void parallelPrefixTest(){
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = i + 1;
        }
        int[] array1 = Arrays.copyOf(array, array.length);
        int[] array2 = Arrays.copyOf(array, array.length);
        System.out.println("初始数组 : " + Arrays.toString(array));

        Arrays.parallelPrefix(array1, (l, r) -> l * r);
        System.out.println("两两相乘后的数组 : " + Arrays.toString(array1));

        Arrays.parallelPrefix(array2, (l, r) -> l + r);
        System.out.println("两两相加后的数组 : " + Arrays.toString(array2));
    }

    public static void parallelSetAllTest(){
        int[] array ={1, 3, 6, 9, 12};
        System.out.println("init array : " + Arrays.toString(array));
        Arrays.parallelSetAll(array, i -> array[i] * 10 );
        System.out.println("after setAll method : " + Arrays.toString(array));
    }
}
