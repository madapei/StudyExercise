package com.mapei.javatest.test_exception;

import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/11
 */
public class MainTest {
    public static void main(String[] args) {
        String test = "j .";
        boolean result = test.matches("\\p{Lower}.*\\.");
        System.out.println(result);
    }
}
