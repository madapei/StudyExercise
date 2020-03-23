package com.mapei.javatest.test_array;

import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/12
 */
public class MainTest {
    public static void main(String[] args) {
        int[] ia = new int[3];
        int[] ib = new int[5];
        String[] sa = new String[3];
        System.out.println("ia.getClass():" + ia.getClass());
        System.out.println("ib.getClass():" + ib.getClass());
        System.out.println("sa.getClass():" + sa.getClass());
        System.out.println(ia.getClass().equals(ib.getClass()));
        System.out.println(ia.getClass().equals(sa.getClass()));
    }
}
