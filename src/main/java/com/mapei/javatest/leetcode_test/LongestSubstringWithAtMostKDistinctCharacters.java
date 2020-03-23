package com.mapei.javatest.leetcode_test;

import java.nio.Buffer;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/3
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
     * @param args
     */
    public static void main(String[] args) {
        String result = LongestSubStr("abcadcassscacccc", 3);
        System.out.println(result);
    }

    private static String LongestSubStr(String str, int count){
        String result = "";
        int max = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); ){
            String subStr = builder.toString();
            if (max <= count){
                if (subStr.indexOf(str.charAt(i)) == -1){
                    if (max < count){
                        builder.append(str.charAt(i));
                        max++;
                        i++;
                    }
                    else {
                        if (result.length() < builder.length()){
                            result = builder.toString();
                        }
                        i = ++j;
                        max = 0;
                        builder.setLength(0);
                    }
                }
                else {
                    builder.append(str.charAt(i));
                    i++;
                }
            }
        }
        if (result.length() < builder.length()){
            result = builder.toString();
        }


        return result;
    }
}
