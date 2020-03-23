package com.mapei.javatest.test_enum;

import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/31
 */
public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ex){
        return random(ex.getEnumConstants());
    }

    public static <T> T random(T[] values){
        return values[random.nextInt(values.length)];
    }
}
