package com.mapei.javatest.gson_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/29
 */
public class GsonTest {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book.class, new BookSerialiser());
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        Book javaPuzzler = new Book();
        javaPuzzler.setTitle("Java Puzzler:Traps, Pitfalls, and Corner Cases");
        javaPuzzler.setIsbn10("032133678x");
        javaPuzzler.setIsbn13("978_934834");
        javaPuzzler.setAuthors(new String[]{"Joshua Bloch", "Neal Gafter"});

        String json = gson.toJson(javaPuzzler);
        System.out.println(json);
    }
}
