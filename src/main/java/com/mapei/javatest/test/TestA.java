package com.mapei.javatest.test;

import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/12/31
 */
public class TestA {
    public void execute(MpCallback mpCallback){
        System.out.println("Initing... ");
        String[] param = "Project Lambda produced the OpenJDK implementation of these features".split(" ");
        Arrays.sort(param, TestA::compare);
        mpCallback.callback(param);
    }

    private static int compare(String a, String b){
        if (a.length() > b.length()){
            return 1;
        }
        else if (a.length() == b.length()){
            return 0;
        }
        else {
            return -1;
        }
    }
}
