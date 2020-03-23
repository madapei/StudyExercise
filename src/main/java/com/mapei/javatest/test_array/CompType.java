package com.mapei.javatest.test_array;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/15
 */
public class CompType implements Comparable<CompType>{
    int i;
    int j;
    public CompType(int n1, int n2){
        i = n1;
        j = n2;
    }

    @Override
    public String toString(){
        String result = "[i = " + i + ", j = " + j + "]";
        return result;
    }

    @Override
    public int compareTo(CompType rv){
        if (i > rv.i)
            return 1;
        if (i == rv.i)
            return 0;
        else
            return -1;
    }


    public static void main(String[] args) {
        CompType[] array1 = {new CompType(2,1), new CompType(1,2), new CompType(3,5), new CompType(3,0)};
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.binarySearch(array1, new CompType(4,3)));
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.binarySearch(array1, new CompType(4,3)));
    }
}
