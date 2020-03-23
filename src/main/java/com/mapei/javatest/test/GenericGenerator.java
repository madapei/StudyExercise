package com.mapei.javatest.test;

import java.util.Date;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/4
 */
public abstract class GenericGenerator {
    public abstract String generate();

    private static Random random = null;

    protected Random getRandomInstance() {
        if (random == null) {
            random = new Random(new Date().getTime());
        }

        return random;
    }
}
