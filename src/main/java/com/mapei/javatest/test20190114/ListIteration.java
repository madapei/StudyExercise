package com.mapei.javatest.test20190114;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */

public class ListIteration {
    public List<Pet> getPets(){
        return Pet.arrayList();
    }

    public static void main(String[] args) {
        ListIteration test = new ListIteration();
        List<Pet> pets = test.getPets();
        ListIterator<Pet> it = pets.listIterator();
        while(it.hasNext()){
            System.out.println(it.next() + "," + it.nextIndex() + "," + it.previousIndex() + ";");
        }
        System.out.println();

        while(it.hasPrevious()){
            System.out.println(it.previous().getName() + " ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(2);
        while (it.hasNext()){
            it.next();
            it.set(new Pet("Ha" + new Random().nextInt(10)));
        }
        System.out.println(pets);
    }
}
