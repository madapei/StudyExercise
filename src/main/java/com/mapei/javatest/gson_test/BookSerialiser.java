package com.mapei.javatest.gson_test;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/29
 */
public class BookSerialiser implements JsonSerializer{
    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        Book book = (Book)src;

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", book.getTitle());
        jsonObject.addProperty("isbn-10", book.getIsbn10());
        jsonObject.addProperty("isbn-13", book.getIsbn13());
        JsonArray jsonAuthorArray = new JsonArray();
        for (String author : book.getAuthors()){
            JsonPrimitive jsonAuthor = new JsonPrimitive(author);
            jsonAuthorArray.add(jsonAuthor);
        }
        jsonObject.add("authors", jsonAuthorArray);
        return jsonObject;
    }

}
