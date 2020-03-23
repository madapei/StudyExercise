package com.mapei.javatest.test_enum;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/4
 */
enum Explore{
    HERA, THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("----------Analyzing " + enumClass + " -----------");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()){
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m :enumClass.getMethods()){
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(num):");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
    }
}
