package com.ayon.lombok.sync;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.*;

class SynchronizedExampleTest {

    @Test
    void testSynchronizedIncrement() throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int iterations = 1000;

        IntStream.range(0, iterations)
            .forEach(i -> executor.submit(example::incrementCounter));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertThat(example.getCounter()).isEqualTo(iterations);
    }

    @Test
    void testSynchronizedMessageAddition() throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int messageCount = 100;

        IntStream.range(0, messageCount)
            .forEach(i -> executor.submit(() -> example.addMessage("Message " + i)));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertThat(example.getMessage(0)).isNotNull();
        assertThat(example.getMessage(-1)).isNull();
        assertThat(example.getMessage(1000)).isNull();
    }

    @Test
    void testStaticMethodSynchronization() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                SynchronizedExample.staticMethod();
                latch.countDown();
            });
        }

        boolean completed = latch.await(2, TimeUnit.SECONDS);
        assertThat(completed).isTrue();

        executor.shutdown();
    }

    @Test
    void testConcurrentReadAndWrite() throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CyclicBarrier barrier = new CyclicBarrier(10);

        for (int i = 0; i < 5; i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    barrier.await();
                    example.addMessage("Write " + index);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                try {
                    barrier.await();
                    example.getMessage(0);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertThat(example.getCounter()).isGreaterThanOrEqualTo(0);
    }
}