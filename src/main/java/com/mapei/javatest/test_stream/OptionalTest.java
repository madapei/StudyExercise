package com.mapei.javatest.test_stream;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/9
 */
public class OptionalTest {
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("d:\\tianfeng.csv")), StandardCharsets.UTF_8);
            List<String> wordList = Arrays.asList(contents.split("\r\n"));

            Optional<String> optionalValue = wordList.stream().filter(s -> s.contains("fred")).findFirst();
            System.out.println(optionalValue.orElse("NO word") + " contains fred");

            Optional<String> optionalString = Optional.empty();
            String result = optionalString.orElse("N/A");
            System.out.println("result:" + result);
            result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
            System.out.println("result:" + result);

            String[] array = wordList.stream().toArray(String[] :: new);
            System.out.println(Arrays.toString(array));
            List<String> list = wordList.stream().collect(Collectors.toList());
            System.out.println(list);
            Set<String> sets = wordList.stream().collect(Collectors.toSet());
            System.out.println(sets);

            System.out.println("---------------------------");
            String str1 = wordList.stream().collect(Collectors.joining());
            System.out.println(str1);

            String str2 = wordList.stream().collect(Collectors.joining("*"));
            System.out.println(str2);
            System.out.println("-----------------------------------");
            IntSummaryStatistics summaryStatistics = wordList.stream().collect(Collectors.summarizingInt(String :: length));
            System.out.println(summaryStatistics.getAverage());
            System.out.println(summaryStatistics.getMax());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
