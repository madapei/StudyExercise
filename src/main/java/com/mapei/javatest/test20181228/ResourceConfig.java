package com.mapei.javatest.test20181228;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
@Configuration
@PropertySource("classpath:test.properties")
public class ResourceConfig {
    @Autowired
    Environment environment;

    @Bean
    public Person getPerson(){
        return new Person(environment.getProperty("name"), environment.getProperty("age", Integer.class, 18));
    }
    @Bean
    public Person getPersonOther(){
        return new Person(environment.getRequiredProperty("name"), environment.getProperty("age", Integer.class));
    }


    public void readValue(){
        System.out.println("name=" + environment.getProperty("name") + ",age=" + environment.getProperty("age"));
    }
}
