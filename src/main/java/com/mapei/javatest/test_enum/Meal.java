package com.mapei.javatest.test_enum;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/31
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            for (Course course : Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("----");
        }
    }
}
