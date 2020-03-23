package com.mapei.javatest.test_containers;

import edu.emory.mathcs.backport.java.util.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/17
 */
class StringAddress{
    private String s;
    public StringAddress(String s){
        this.s = s;
    }
    public String toString(){
        return s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);

        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
