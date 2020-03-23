package com.mapei.javatest.test20190102;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
public class AudienceXml {
    private Map<Integer, Integer> songCountMap = new HashMap<Integer,Integer>();

    public void silenceCellPhone(){
        System.out.println("Silencing cell phone!");
    }

    public void applause(){
        System.out.println("Applausing!");
    }

    public void demandRefund(){
        System.out.println("Demanding refund");
    }

    public void aroundTest(ProceedingJoinPoint joinPoint){
        System.out.println("Wow!");
        try{
            joinPoint.proceed();
        }
        catch (Throwable e){
            e.getMessage();
        }
        System.out.println("哎呀妈！");
    }

    public void recodeSondNum(int songNums){
        int danceCount = songCountMap.containsKey(songNums) ? songCountMap.get(songNums) : 0;
        songCountMap.put(songNums, ++danceCount);
    }

    public void printSondCount(){
        for (Map.Entry<Integer, Integer> entry : songCountMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
