package com.mapei.javatest.test;

import java.util.function.Consumer;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/30
 */
public class Functionnal {
    public static void main(String[] args) {
        Consumer<Book> gretter = p -> System.out.println("Hello" + p.getName());
        gretter.accept(new Book("Think in Java"));
    }
}
