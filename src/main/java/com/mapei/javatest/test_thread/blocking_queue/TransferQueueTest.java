package com.mapei.javatest.test_thread.blocking_queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/6/4
 */
public class TransferQueueTest {

    @Test
    public void oneProducerZeroConsumer_Test() throws InterruptedException{
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Producer producer1 = new Producer(transferQueue, "p1", 3);
        Producer producer2 = new Producer(transferQueue, "p2", 3);
        Consumer consumer1 = new Consumer(transferQueue, "c1", 3);
        Consumer consumer2 = new Consumer(transferQueue, "c2", 3);
        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        executorService.awaitTermination(20000, TimeUnit.MILLISECONDS);
        executorService.shutdown();

        Assert.assertEquals(producer1.numberOfProducedMessage.intValue(), 3);
        Assert.assertEquals(producer2.numberOfProducedMessage.intValue(), 3);
    }
}

class Producer implements Runnable{
    TransferQueue<String> transferQueue;
    String name;
    Integer numberOfMessagesToProduce;
    AtomicInteger numberOfProducedMessage = new AtomicInteger();

    public Producer(TransferQueue<String> transferQueue, String name, Integer numberOfMessagesToProduce) {
        this.transferQueue = transferQueue;
        this.name = name;
        this.numberOfMessagesToProduce = numberOfMessagesToProduce;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfMessagesToProduce; i++){
            try {
                System.out.println("----- Producer "  + name + " is waiting to transfer Message -----");
                boolean added = transferQueue.tryTransfer("Message" + i, 4000, TimeUnit.MILLISECONDS);
                if (added){
                    numberOfProducedMessage.incrementAndGet();
                    System.out.println("----- Producer " + name + " transfered Message " + i + " -----");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer implements Runnable{
    TransferQueue<String> transferQueue;
    String name;
    int numberOfMessagesToConsume;
    AtomicInteger numberOfConsumedMessage = new AtomicInteger();

    public Consumer(TransferQueue<String> transferQueue, String name, int numberOfMessagesToConsume) {
        this.transferQueue = transferQueue;
        this.name = name;
        this.numberOfMessagesToConsume = numberOfMessagesToConsume;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfMessagesToConsume; i++){
            try {
                System.out.println("****** Consumer " + name + " is waiting to task element *****");
                String element = transferQueue.take();
                longProcessing(element);
                System.out.println("***** Consumer " + name+ " taked Message : " + element + "  *****");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void longProcessing(String element) throws InterruptedException{
        numberOfConsumedMessage.incrementAndGet();
        Thread.sleep(500);
    }
}
