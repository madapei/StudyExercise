package com.mapei.javatest.test20190114;

import java.util.LinkedList;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<Pet>(Pet.arrayList());
        System.out.println(pets);
        System.out.println("pets.getFirst()：" + pets.getFirst());
        // 获取但不移除此列表的头（第一个元素）
        System.out.println("pets.element()：" + pets.element());
        //获取但不移除此列表的头（第一个元素）
        System.out.println("pets.peek()：" + pets.peek());
        //获取并移除此列表的头（第一个元素）
        System.out.println("pets.remove()：" + pets.remove());
        System.out.println("pets.removeFirst()：" + pets.removeFirst());
        //获取并移除此列表的头（第一个元素）
        System.out.println("pets.poll()：" + pets.poll());
        System.out.println(pets);
        pets.addFirst(new Pet("newPet1"));
        System.out.println("After addFirst():" + pets);
        //将指定元素添加到此列表的末尾（最后一个元素）
        pets.offer(new Pet("newPet2"));
        System.out.println("After offer():" + pets);
        //将指定元素添加到此列表的结尾
        pets.add(new Pet("newPet3"));
        System.out.println("After add():" + pets);
        pets.addLast(new Pet("newPet4"));
        System.out.println("After addLast():" + pets);
        System.out.println("pets.removeLast():" + pets.removeLast());
        System.out.println(pets);
    }
}
