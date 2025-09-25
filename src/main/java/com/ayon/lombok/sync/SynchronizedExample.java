package com.ayon.lombok.sync;

import lombok.Synchronized;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {

    private final Object readLock = new Object();
    private final Object writeLock = new Object();
    private int counter = 0;
    private List<String> messages = new ArrayList<>();

    @Synchronized
    public void incrementCounter() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " - Counter: " + counter);
    }

    @Synchronized
    public int getCounter() {
        return counter;
    }

    @Synchronized("readLock")
    public String getMessage(int index) {
        if (index >= 0 && index < messages.size()) {
            return messages.get(index);
        }
        return null;
    }

    @Synchronized("writeLock")
    public void addMessage(String message) {
        messages.add(message);
        System.out.println(Thread.currentThread().getName() + " added: " + message);
    }

    @Synchronized
    public static void staticMethod() {
        System.out.println(Thread.currentThread().getName() + " - In static synchronized method");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Testing instance method synchronization:");
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> example.incrementCounter());
        }

        Thread.sleep(500);

        System.out.println("\nTesting named lock synchronization:");
        for (int i = 0; i < 5; i++) {
            final int index = i;
            executor.submit(() -> example.addMessage("Message " + index));
        }

        Thread.sleep(500);

        System.out.println("\nTesting static method synchronization:");
        for (int i = 0; i < 3; i++) {
            executor.submit(SynchronizedExample::staticMethod);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\nFinal counter value: " + example.getCounter());
        System.out.println("Total messages: " + example.messages.size());
    }
}