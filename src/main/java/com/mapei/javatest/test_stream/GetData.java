package com.mapei.javatest.test_stream;

import java.nio.ByteBuffer;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/27
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit()){
            if (bb.get() != 0){
                System.out.println("none zero");
            }
        }
        System.out.println("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");

        char c;
        while ((c = bb.getChar()) != 0){
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();

        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());
        bb.rewind();

        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();

        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());

        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();

        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
