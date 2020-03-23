package com.mapei.javatest.test20190102;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
@Aspect
public class Audience {

    /*@Before("execution(* com.mapei.javatest.test20190102.Performance.perform(..))")
    public void silenceCellPhone(){
        System.out.println("Silencing cell phone!");
    }

    @AfterReturning("execution(* com.mapei.javatest.test20190102.Performance.perform())")
    public void applause(){
        System.out.println("Applausing!");
    }

    @AfterThrowing("execution(* com.mapei.javatest.test20190102.Performance.perform())")
    public void demandRefund(){
        System.out.println("Demanding refund");
    }*/

    /*@Pointcut("execution(* com.mapei.javatest.test20190102.Performance.perform())")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhone(){
        System.out.println("Silencing cell phone!");
    }

    @After("performance()")
    public void applause(){
        System.out.println("Applausing!");
    }

    @Around("execution(* com.mapei.javatest.test20190102.Performance.aroundPerform(..))")
    public void aroundTest(ProceedingJoinPoint joinPoint){
        System.out.println("Wow!");
        try{
            joinPoint.proceed();
        }
        catch (Throwable e){
            e.getMessage();
        }
        System.out.println("哎呀妈！");
    }*/

    private Map<Integer, Integer> songCountMap = new HashMap<Integer,Integer>();

    @Pointcut("execution(* com.mapei.javatest.test20190102.Performance.danceSong(int)) && args(abc)")
    public void pointCutTest(int abc){}

    @AfterReturning("pointCutTest(songNums)")
    public void recodeSondNum(int songNums){
        int danceCount = songCountMap.containsKey(songNums) ? songCountMap.get(songNums) : 0;
        songCountMap.put(songNums, ++danceCount);
    }

    @After("execution(* com.mapei.javatest.test20190102.Performance.printDanceSongCount())")
    public void printSondCount(){
        for (Map.Entry<Integer, Integer> entry : songCountMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

}
