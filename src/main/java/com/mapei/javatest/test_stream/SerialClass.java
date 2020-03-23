package com.mapei.javatest.test_stream;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/24
 */
public class SerialClass implements Serializable{
    private Integer age;
    private String name;
    private Date birth;

    public SerialClass() {
        System.out.println("SerialClass Constructor!");
    }

    public SerialClass(Integer age, String name, Date birth) {
        this.age = age;
        this.name = name;
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "SerialClass{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
