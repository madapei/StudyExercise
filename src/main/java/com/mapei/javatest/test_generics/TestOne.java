package com.mapei.javatest.test_generics;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/4
 */
public class TestOne {
    private String name;
    private Integer age;

    public TestOne(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public java.lang.String toString() {
        return "TestOne{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public <T,S> S getLength(T a){
        if (a instanceof String){
            return (S)Integer.valueOf("Hello".length());
        }
        else if (a instanceof Integer){
            return (S)Integer.valueOf(String.valueOf(a).length());
        }
        else {
            return (S)a;
        }
    }
}
