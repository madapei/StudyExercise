package com.mapei.javatest.test_stream;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/21
 */
public class GZIPcompress {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("F:\\test_file\\test.txt"));
            BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("F:\\test_file\\test.gz")));
            int c;
            while ((c = in.read()) != -1){
                out.write(c);
            }
            in.close();
            out.close();
            System.out.println("Reading file");
            BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
            String s;
            while ((s = in2.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
