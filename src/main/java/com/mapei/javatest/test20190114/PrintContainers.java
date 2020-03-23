package com.mapei.javatest.test20190114;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */
public class PrintContainers {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map){
        map.put("rat","Fuzzy");
        map.put("cat", "Rags");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new HashMap<String, String>()));
    }
}
