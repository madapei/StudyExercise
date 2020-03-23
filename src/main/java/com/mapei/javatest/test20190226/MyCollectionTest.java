package com.mapei.javatest.test20190226;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/2/27
 */
public class MyCollectionTest {
    public static void main(String[] args) {
        String[] strArray = {"mapei", "dapei", "peipei", "daxian", "dashen"};
        MyCollection collection = new MyCollection(strArray);
        for (String item : collection){
            System.out.println(item);
        }

        Map<String, String> map = new HashMap<String, String>();
    }
}
