package com.mapei.javatest.test_stream;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/14
 */
public class Father {
    private String name;

    public String getName(){
        return name;
    }

    public static String name(){
        return "father";
    }

    public static String upperName(){
        return "father".toUpperCase();
    }
}
