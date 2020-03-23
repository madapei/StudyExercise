package com.mapei.spring.service.impl;

import com.mapei.spring.service.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/19
 */
public class SgtPeppers implements CompactDisc{
    private String discName;
    public void play(){
        System.out.println("SgtPeppers play");
    }

    public void setName(String name){
        this.discName = name;
    }
}
