package com.mapei.javatest.test20181228.placeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
@Component
public class Book {
    private String name;
    private String author;

    public Book(@Value("${name}") String name, @Value("${author}") String author) {
        this.name = name;
        this.author = author;
    }


    public void printBook(){
        System.out.println("name="+ name + ",author=" + author);
    }
}
