package com.mapei.javatest.test_stream;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/5
 */
public class StreamTest1 {
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("D:\\The Devil Wears Prada .txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split(" "));
            Stream<String> ss = words.stream().map(s -> s.toUpperCase());
            ss.limit(10).forEach(t -> {
                System.out.print(t + " **");
            });
            System.out.println();
            Stream<String> ssnew = words.stream().map(String::toUpperCase);
            ssnew.limit(10).forEach(t -> System.out.print(t + " **"));
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSSS");
//            System.out.println("=======" + sdf.format(new Date()));
//            long count = words.stream().filter(w -> w.length() > 15).count();
//            System.out.println(count);
//            System.out.println("=======" + sdf.format(new Date()));
//            System.out.println();
//            System.out.println("*******" + sdf.format(new Date()));
//            long countNew = words.parallelStream().filter(w -> w.length() > 15).count();
//            System.out.println(countNew);
//            System.out.println("*******" + sdf.format(new Date()));

//            String[] array = {"hello","ma","da", "pei"};
//            Stream<String> stream = Stream.of(array);
//            stream.sorted().forEach(t -> System.out.println(t));
            Stream<String> stream = Files.lines(Paths.get("D:\\stream_test.txt"));
            stream.forEach(t -> {
                System.out.println(t); System.out.println("********************");
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
