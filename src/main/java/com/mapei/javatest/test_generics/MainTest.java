package com.mapei.javatest.test_generics;

import javax.swing.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/15
 */
public class MainTest {
    public static void main(String[] args) {
        MainTest t = new MainTest();
        t.test();
    }

    public void test(){

    }

    public void minmaxBonux(Manager[] a, Pair<? super Manager> result){
        if (a.length == 0)
            return ;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++){
            if (min.getBonus() > a[i].getBonus())
                min = a[i];
            if (max.getBonus() < a[i].getBonus())
                max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }
}
