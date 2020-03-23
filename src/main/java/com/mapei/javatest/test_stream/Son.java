package com.mapei.javatest.test_stream;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/14
 */
public class Son extends Father{
    @Override
    public String getName() {
        return super.getName();
    }

    public static String name(){
        return name() + "_son";
    }
}


