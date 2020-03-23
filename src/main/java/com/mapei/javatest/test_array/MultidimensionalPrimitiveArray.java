package com.mapei.javatest.test_array;

import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/13
 */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, },
                {4, 5, 6, }
        };
        // deepToString(Object[] a):
        // 返回指定数组的“深度内容”的字符串表示形式。 如果数组包含其他数组作为元素
        // ，则字符串表示包含其内容等等。 此方法用于将多维数组转换为字符串
        System.out.println(Arrays.deepToString(a));

        int[][][] b = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7, 8, 9}
                }
        };
        System.out.println(Arrays.deepToString(b));
    }
}
