package com.mapei.javatest.leetcode_test;

import com.mapei.javatest.test_containers.ToDoList;

import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/27
 */
public class ToLowerCase {
    public static void main(String[] args) {
        ToLowerCase test = new ToLowerCase();
        System.out.println(test.toLowerCase("MaDaPEI"));
    }

    public String toLowerCase(String str) {
        if (str == null || str.equals("")){
            return "";
        }
        String result = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90){
                result += String.valueOf((char)(str.charAt(i) + 32));
            }
            else {
                result += str.charAt(i);
            }

        }
        return result;
    }
}
