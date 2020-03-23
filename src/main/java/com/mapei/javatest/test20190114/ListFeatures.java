package com.mapei.javatest.test20190114;


import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */
public class ListFeatures {
    public static List initList(){
        List<String> pets  = new ArrayList<String>(Arrays.asList("dahua","mimi","miaomiao","dabai","maomao","xiaomi","xiaohuang"));
        return pets;
    }

    public static void main(String[] args) {
        List<String> pets = initList();
        System.out.println("1:" + pets);
        pets.add(1,"dapei");
        System.out.println("1.5" + pets);
        pets.add("beibei");
        System.out.println("2:" + pets);
        System.out.println("3" + pets.contains("mimi"));
        pets.remove("beibei");
        System.out.println("4" + pets.indexOf("dabai"));
        pets.remove("dabai");
        System.out.println(pets);
        List<String> sub = pets.subList(1,4);
        System.out.println(sub);
        System.out.println(pets.containsAll(sub));
        Collections.sort(pets);
        System.out.println(pets);
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println("sorted list:" + intList);
        List<Integer> subIntList = intList.subList(3,6);
        System.out.println("Has subList:" + intList.containsAll(subIntList) + ",subIntList:" + subIntList);
        Collections.shuffle(intList);
        System.out.println("sheffle list" + intList);
        System.out.println("Has subList:" + intList.containsAll(subIntList) + ",subIntList:" + subIntList);

    }
}
