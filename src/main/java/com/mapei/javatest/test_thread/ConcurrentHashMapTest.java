package com.mapei.javatest.test_thread;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/6
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        test4();
    }

    public static void test1(){
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.put("word", 12L);
        map.put("hello", 23L);
        System.out.println("init --- " + map.toString());
        map.compute("word", (k, v) -> {
            if (v > 10L){
                return 10L;
            }
            else{
                return 1L;
            }
        });
        System.out.println("word compute --- " + map.toString());

        map.computeIfAbsent("mapei", k -> 10L);
        System.out.println("mapei computeIfAbsent --- " + map.toString());
        map.computeIfPresent("mapei", (k, v) -> v+11L);
        System.out.println("mapei computeIfPresent --- " + map.toString());
        map.computeIfPresent("pei", (k, v) -> v+11L);
        System.out.println("pei computeIfPresent --- " + map.toString());

        map.merge("hello", 12L, (v1, v2) -> v1 * 2 + 10L);
        System.out.println("hello merge notnull --- " + map.toString());
        map.merge("haha", 12L, (v1, v2) -> v1 * 10 +v2);
        System.out.println("haha merge notnull --- " + map.toString());

        map.compute("haha", (k, v) -> null);
        System.out.println("haha compute null --- " + map.toString());
//        map.merge("hello", 2L, (v1, v2) -> 1L);
//        System.out.println("hello merge notnull --- " + map.toString());
        map.merge("hello", 2L, (v1, v2) -> null);
        System.out.println("hello merge null --- " + map.toString());
    }

    public static void test2(){
        ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, LongAdder> map1 = new ConcurrentHashMap<>();
        try {
            File file = new File("D:\\en_test.txt");

            /*Path path = Paths.get(file.getAbsolutePath());
            List<String> strList = Files.readAllLines(path);
            strList.stream().forEach(s -> {
                map1.putIfAbsent(s, new LongAdder());
                map1.get(s).increment();
            });
            String result = map1.search(1, (k, v) -> (v.longValue() > 500) ? k : null);
            System.out.println("方法一：" + result);*/

            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null){
                if ("".equals(line.trim())){
                    line = bufferedReader.readLine();
                    continue;
                }
                map.putIfAbsent(line, new LongAdder());
                map.get(line).increment();
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();



            String result1 = map.search(1, (k, v) -> (v.longValue() > 500) ? k : null);
            System.out.println(result1);
            map.forEach(1, (k, v) -> System.out.println(k + "<>" + v));
            map.forEach(1, (k, v) -> (v.longValue() > 500) ? k + " - " + v : null, System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3(){
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.putIfAbsent("mapei", 1L);
        map.putIfAbsent("pei", 2L);
        map.putIfAbsent("peier", 3L);
        map.putIfAbsent("peipei", 4L);
        map.putIfAbsent("mahao", 5L);
        map.putIfAbsent("laoma", 6L);
        map.putIfAbsent("laohuo", 7L);

        Long result1 = map.reduce(1, (k, v)-> k.indexOf("pei") != -1 ? v : null, Long::sum);
        System.out.println("pei result --- " + result1.longValue());//10

        Long result2 = map.reduce(1, (k, v) -> k.indexOf("ma") != -1 ? v : null, Long::sum);
        System.out.println("ma result --- " + result2.longValue()); //12

        Long result3 = map.reduce(1, (k, v) -> k.indexOf("lao") != -1 ? v : null, Long::sum);
        System.out.println("lao result --- " + result3.longValue()); //13

        Long reduceKey1 = map.reduceKeys(1, k -> k.indexOf("hao") != -1 ? map.get(k) : null , Long::sum);
        System.out.println("reduceKey1 result --- " + reduceKey1.longValue()); //5

        Long reduceValues = map.reduceValues(1, v -> v >= 5 ? v : null , Long::sum);
        System.out.println("reduceValues result --- " + reduceValues.longValue()); //18
    }

    public static void test4(){
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.putIfAbsent("mapei", 1L);
        map.putIfAbsent("pei", 2L);
        map.putIfAbsent("peier", 3L);
        System.out.println("init map values : " + map.toString());

        Set<String> set = map.keySet(2L);
        set.add("hello");
        System.out.println("after add hello : " + map.toString());
        set.remove("pei");
        System.out.println("after remove pei : " + map.toString());
        set.addAll(Arrays.asList("aaa", "bbb", "ccc"));
        System.out.println("after add list : " + map.toString());
        set.removeIf(k -> k.indexOf("pei") != -1);
        System.out.println("after remove if like pei : " + map.toString());
    }
}
