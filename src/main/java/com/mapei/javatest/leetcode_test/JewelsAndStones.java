package com.mapei.javatest.leetcode_test;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/27
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (S == null || J == null || S.equals("")){
            return 0;
        }
        int count = 0;
        char[] js = J.toCharArray();
        for (char c : js){
            for (char s : S.toCharArray()){
                if (c == s){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones test = new JewelsAndStones();
        System.out.println(test.numJewelsInStones("z", "ZZ"));
    }
}
