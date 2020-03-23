package com.mapei.spring.service.impl;

import com.mapei.spring.service.CdPlayer;
import com.mapei.spring.service.CompactDisc;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/22
 */
public class CdPlayerTwo implements CdPlayer{
    private CompactDisc compactDisc;

    public CdPlayerTwo(CompactDisc compactDisc) {
        System.out.println("CdPlayerTwo and CompactDisc is " + compactDisc.hashCode());
        this.compactDisc = compactDisc;
    }

    public void startPlay(){
        compactDisc.play();
    }
}
