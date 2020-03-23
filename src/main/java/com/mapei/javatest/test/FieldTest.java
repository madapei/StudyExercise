package com.mapei.javatest.test;

import java.lang.reflect.Field;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/22
 */
class MaPei{
    private int age = 28;
    private String name = "mapei";
    public void print(){
        System.out.println("Hello!");
    }
}

public class FieldTest {
    public static void main(String[] args) {
        MaPei maPei = new MaPei();
        Class c = maPei.getClass();
        try {
            Field f1 = c.getDeclaredField("name");
            f1.setAccessible(true);
            Object o1 = f1.get(maPei);
            System.out.println(o1);

            Field f2 = c.getDeclaredField("age");
            f2.setAccessible(true);
            Integer i2 = f2.getInt(maPei);
            System.out.println(i2);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
