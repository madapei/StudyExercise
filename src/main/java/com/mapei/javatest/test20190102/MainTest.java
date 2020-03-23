package com.mapei.javatest.test20190102;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
public class MainTest {
    private ApplicationContext context;

    public void init(){
        context = new AnnotationConfigApplicationContext(PerformConfig.class);
    }

    public static void main(String[] args) {
        MainTest test = new MainTest();
        test.init();
//        test.encoreableTest();
    }

    public void aopTest1(){
        Performance performance = context.getBean(Performance.class);
        try{
            performance.perform1();
        }
        catch (Exception e){
            e.getMessage();
        }

    }

    public void aopTest2(){
        Performance performance = context.getBean(Performance.class);
        performance.perform();
    }

    public void aroundTest(){
        Performance performance = context.getBean(Performance.class);
        performance.aroundPerform("mapei");
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

    /*public void encoreableTest(){
        Performance performance = context.getBean(Performance.class);
        Encoreable encoreable = (Encoreable)performance;
        encoreable.addMethod();
        System.out.println(encoreable.getYear());
    }*/
}
