package com.mapei.javatest.test_containers;

import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/22
 */
public class Prediction {
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;
    public String toString(){
        if (shadow){
            return "Six more weeks of Winter!";
        }
        else {
            return "Early Spring!";
        }
    }
}
