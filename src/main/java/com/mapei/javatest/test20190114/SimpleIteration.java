package com.mapei.javatest.test20190114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */
public class SimpleIteration {
    public List<String> getPets(){
        return new ArrayList<String>(Arrays.asList("dahua","mimi","miaomiao","dabai","maomao","xiaomi"));
    }

    public static void main(String[] args) {
        SimpleIteration si = new SimpleIteration();
        List<String> pets = si.getPets();
        Iterator<String> iterator = pets.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        for (String s : pets){
            System.out.println(s);
        }
        System.out.println();
        iterator = pets.iterator();
        for (int i = 0; i < 4; i++){
            iterator.next();
            iterator.remove();
        }
        System.out.println(pets);
    }
}
