package com.mapei.javatest.test;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/28
 */
class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void print(){
        System.out.println("name=" + name);
    }
}

public class StringTest {

    public static void main(String[] args) throws Exception {
        String s = "hello world mapei ha ha !";
        String[] s1 = s.split(" ");
        System.out.println(Arrays.toString(s1));
        String[] s2 = s.split("\\s+");
        System.out.println(Arrays.toString(s2));
        System.out.println(StringUtils.countMatches(s, "d"));
    }
}
