package com.mapei.javatest.test_stream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/9
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            ZipInputStream zin = new ZipInputStream(new FileInputStream("F:\\test_file\\test_file.zip"));
            ZipEntry entry ;
            while ((entry = zin.getNextEntry()) != null){
                String name = entry.getName();

                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
