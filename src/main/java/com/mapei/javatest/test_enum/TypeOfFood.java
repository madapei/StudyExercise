package com.mapei.javatest.test_enum;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/31
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SOUP;
        food = Food.MainCourse.PAD_THAI;
        food = Food.Dessert.BLACK_FOREST_CAKE;
        food = Food.Coffee.TEA;
    }
}
