package com.mapei.javatest.test20181228.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
public class PlaceHolderMainTest {
    private ApplicationContext context;

    public void init(){
        context = new AnnotationConfigApplicationContext(PlaceHolderConfig.class);
    }

    public void placeHolderTest(){
        Book book = context.getBean(Book.class);
        book.printBook();
    }

    public static void main(String[] args) {
        PlaceHolderMainTest test = new PlaceHolderMainTest();
        test.init();
        test.placeHolderTest();
    }
}
