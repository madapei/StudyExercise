package com.mapei.javatest.test;

import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/23
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] array1 = new int[6];
        Arrays.fill(array1, 5);
        System.out.println(Arrays.toString(array1));

        Integer[] array2 = new Integer[6];
        Arrays.fill(array2, new Integer(4));
        System.out.println(Arrays.toString(array2));

        Integer[] array3 = new Integer[6];
        Arrays.fill(array3, new Integer(8));
        System.out.println(Arrays.toString(array3));

        System.arraycopy(array3, 0, array2, 0, 3);
        System.out.println(Arrays.toString(array2));

    }
}
