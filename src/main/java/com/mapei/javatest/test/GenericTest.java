package com.mapei.javatest.test;

import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/23
 */
public class GenericTest<T> {
    public static void main(String[] args) {
        int[][] intArray1 = {{1,2,3,4},{1}};
        int[][] intArray2 = {{1,2,3,4},{1}};
        System.out.println(Arrays.deepEquals(intArray1, intArray2));
    }
}
