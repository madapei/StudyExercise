package com.mapei.javatest.test_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/4/16
 */
public class PhaserTest {
    public static void main(String[] args) {
        /*Phaser phaser = new Phaser(4);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            executorService.execute(new Passengerp(i, phaser));
        }

        executorService.shutdown();*/



        Phaser phaser = new Phaser(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            phaser.register();
            executorService.execute(new Passengerp(i, phaser));
        }
        phaser.arriveAndDeregister();
        executorService.shutdown();
    }
}

class Passengerp implements Runnable{
    private int id;
    private Phaser phaser;

    public Passengerp(int id, Phaser phaser) {
        this.id = id;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("Passenger" + id + " has arrived!");
        phaser.arriveAndAwaitAdvance();
        System.out.println("Passenger" + id + " gogooo!");
    }
}
