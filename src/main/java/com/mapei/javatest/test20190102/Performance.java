package com.mapei.javatest.test20190102;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
public interface Performance {
    void perform1() throws Exception;

    void perform();

    void perform(String args) throws RuntimeException;

    void aroundPerform(String name);

    void danceSong(int songNum);

    void printDanceSongCount();
}
