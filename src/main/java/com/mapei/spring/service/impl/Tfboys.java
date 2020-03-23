package com.mapei.spring.service.impl;

import com.mapei.spring.service.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/19
 */
@Component("tfboys")
public class Tfboys implements CompactDisc{
    public void play(){
        System.out.println("Tfboys play");
    }
}
