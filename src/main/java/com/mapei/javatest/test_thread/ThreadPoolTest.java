package com.mapei.javatest.test_thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/3/20
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory: ");
            String directory = in.nextLine();
            System.out.print("Enter key word: ");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();
//            Executors.newFixedThreadPool(2);
//            Executors.newSingleThreadExecutor();
            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get() + " matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
            System.out.println("largest pool size=" + largestPoolSize);
        }
    }
}

class MatchCounter implements Callable<Integer>{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool){
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();
        for (File file : files){
            if (file.isDirectory()){
                MatchCounter counter = new MatchCounter(file, keyword, pool);
                Future<Integer> result = pool.submit(counter);
                results.add(result);
            }
            else {
                if (search(file)){
                    count++;
                }
            }
        }

        for (Future<Integer> result : results){
            try {
                count += result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public boolean search(File file){
        try {
            try (Scanner in = new Scanner(file, "UTF-8")){
                boolean found = false;
                while (!found && in.hasNextLine()){
                    String line = in.nextLine();
                    if (line.contains(keyword)){
                        found = true;
                    }
                }
                return found;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
