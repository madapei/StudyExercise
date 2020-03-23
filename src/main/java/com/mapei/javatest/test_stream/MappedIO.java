package com.mapei.javatest.test_stream;

import java.io.IOException;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/2
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;
    private abstract static class Tester{
        private String name;
        public Tester(String name){
            this.name = name;
        }
        public void runTest(){
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public abstract void test() throws IOException;

    }
}
