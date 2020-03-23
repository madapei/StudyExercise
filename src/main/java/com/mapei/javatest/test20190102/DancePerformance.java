package com.mapei.javatest.test20190102;

import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
@Component
public class DancePerformance implements Performance{

    public void perform1() throws Exception{
        System.out.println("Start Dancing!");
        throw new Exception("Aha,so bad!");
    }

    public void perform(){
        System.out.println("Start Dancing!");
    }

    public void perform(String args) throws RuntimeException{
        if ("throws".equals(args)){
            throw new RuntimeException();
        }
        else {
            System.out.println("Start Dancing!");
        }
    }

    public void aroundPerform(String name){
        System.out.println(name + "said: this is a around perform!");
    }

    public void danceSong(int songNum){
        System.out.println("Dancing song of num " + songNum);
    }

    public void printDanceSongCount(){
        System.out.println("Start printing:");
    }
}
