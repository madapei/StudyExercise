package com.mapei.javatest.test_thread.blocking_queue;

import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/6/3
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        // create object of DelayQueue
        // using DelayQueue() constructor
        BlockingQueue<DelayObject> DQ
                = new DelayQueue<DelayObject>();

        // Add numbers to end of DelayQueue
        DQ.add(new DelayObject("Aa", 1));
        DQ.add(new DelayObject("Bb", 2000));
        DQ.add(new DelayObject("Cccc", 30));
        DQ.add(new DelayObject("D", 4000));

        // print Dequee
        System.out.println("DelayQueue: "
                + DQ);

        System.out.println("----" + DQ.peek());

        int size = DQ.size();
        while (size > 0){
            DelayObject o = DQ.poll();
            if (o != null){
                System.out.println("size= " + size + ", item= " + o);
            }
            size = DQ.size();
        }
    }
}

class DelayObject implements Delayed {
    private String name;
    private long time;

    // Contructor of DelayObject
    public DelayObject(String name, long delayTime)
    {
        this.name = name;
        this.time = System.currentTimeMillis()
                + delayTime;
    }

    // Implementing getDelay() method of Delayed
    @Override
    public long getDelay(TimeUnit unit)
    {
        long diff = time - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    // Implementing compareTo() method of Delayed
    @Override
    //按延期时间有小到大排序
    /*public int compareTo(Delayed obj)
    {
        if (this.time < ((DelayObject)obj).time) {
            return -1;
        }
        if (this.time > ((DelayObject)obj).time) {
            return 1;
        }
        return 0;
    }*/
    //按name字符个数由小到大排序
    public int compareTo(Delayed obj){
        if (this.name.length() < ((DelayObject)obj).name.length()){
            return -1;
        }
        else if (this.name.length() > ((DelayObject)obj).name.length()){
            return 1;
        }
        else {
            return 0;
        }
    }

    // Implementing toString() method of Delayed
    @Override
    public String toString()
    {
        return "{"
                + "name=" + name
                + ", time=" + time
                + "}";
    }
}
