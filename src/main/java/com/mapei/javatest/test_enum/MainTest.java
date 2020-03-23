package com.mapei.javatest.test_enum;

import java.nio.file.Files;
import java.util.Scanner;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/13
 */
enum Shrubberys{
    GROUND,
    CRAWLING,
    HANGING
}

public class MainTest {
    public static void main(String[] args) {
        System.out.println(Shrubberys.GROUND.getClass());
    }
}
