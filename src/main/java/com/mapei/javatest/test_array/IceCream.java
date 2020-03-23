package com.mapei.javatest.test_array;

import com.mapei.javatest.test_generics.ArrayAlg;
import com.mapei.javatest.test_generics.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/13
 */
public class IceCream {
    private static Random rand = new Random();
    static final String[] FALVORS = {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
    "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pid"};

    public static String[] flavorSet(int n){
        if (n > FALVORS.length){
            throw new IllegalArgumentException("Set too big");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FALVORS.length];
        for (int i = 0; i < n; i++){
            int t;
            do{
                t = rand.nextInt(FALVORS.length);
            }
            while (picked[t]); //这里的判断确保不会重复选择
            results[i] = FALVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
