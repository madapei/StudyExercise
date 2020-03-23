package com.mapei.javatest.test_stream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/10
 */
public class PrintWriterTest {
    public static void main(String[] args) {
        try {
            /*PrintWriter printWriter = new PrintWriter("D:" + File.separator + "PrintWriterTest.txt");
            printWriter.print("Hello ");
            printWriter.println(" World!");
            printWriter.println("嚯哈哈哈哈哈哈哈");
            printWriter.close();

            PrintStream printStream = new PrintStream("D:" + File.separator + "PrintStream.txt");
            printStream.print("Hello ");
            printStream.println(" World!");
            printStream.println(new Integer(4444));
            char[] chars = {'s', 'd', 'k'};
            printStream.println(chars);
            byte[] bArray = Files.readAllBytes(Paths.get("d:/tianfeng.csv"));
            printStream.write(bArray);
            printStream.close();*/

            /*List<String> lines = Files.readAllLines(Paths.get("d:/tianfeng.csv"), Charset.forName("GBK"));
            System.out.println(lines);*/
            System.out.println(Charset.defaultCharset());
            Charset c = Charset.availableCharsets().get("GBK");
            System.out.println(c.toString());
            Random r = new Random();
        }
        /*catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }*/
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
