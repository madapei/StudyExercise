package com.mapei.javatest.test_enum;

import com.mapei.javatest.test_array.Generator;
import com.sun.tools.javac.jvm.Gen;
import sun.nio.cs.Surrogate;

import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/31
 */
enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random random = new Random(47);
    public CartoonCharacter next(){
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> args){
        System.out.print(args.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10 ; i++){
            printNext(cc);
        }
    }
}
