package com.mapei.javatest.test_enum;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/4
 */
enum Search{
    HITHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
//        e.values();
        for (Enum en : e.getClass().getEnumConstants()){
            System.out.println(en);
        }
    }
}
