package com.mapei.javatest.test20190102;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
public class XmlMainTest {
    /*private ApplicationContext context;

    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:aspect-test.xml");
    }

    public static void main(String[] args) {
        XmlMainTest test = new XmlMainTest();
        test.init();
//        test.xmlTest();
//        test.danceSongTest();
//        test.testEncoreable();
    }

    public void xmlTest(){
        Performance performance = context.getBean(Performance.class);
        performance.perform();
//        try{
//            performance.perform("throws");
//        } catch (RuntimeException e){
//            e.getMessage();
//        }
    }

    public void danceSongTest(){
        Performance performance = context.getBean(Performance.class);
        Random random = new Random();
        int i = 0;
        while (i < 10){
            int num = random.nextInt(4);
            if (num == 0){
                continue;
            }
            performance.danceSong(num);
            i++;
        }

        performance.printDanceSongCount();
    }

    public void testEncoreable(){
        Performance performance = context.getBean(Performance.class);
        Encoreable encoreable = (Encoreable)performance;
        encoreable.addMethod();
        System.out.println(encoreable.getYear());
    }*/
}
