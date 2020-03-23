package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/23
 */
interface Light{
    void work();
}

interface Song{
    void work();
}

public class CallBackTest implements Light, Song{
    public void work(){
        System.out.println("working");
    }

    public static void main(String[] args) {
        Light light = new CallBackTest();
        light.work();
        Song song = new CallBackTest();
        song.work();
    }
}
