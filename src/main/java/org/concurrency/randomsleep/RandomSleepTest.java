package org.concurrency.randomsleep;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RandomSleepTest {

    public static void main(String[] args) {
        final ExecutorService exec = Executors.newCachedThreadPool();
        int numOfTasks = 0;
        if (args.length > 0) {
            numOfTasks = Integer.parseInt(args[0]);
        }

        for (int i = 0; i < numOfTasks; i++) {
            exec.execute(() -> {
                final Random rnd = new Random();
                final int sec = rnd.nextInt(10) + 1;
                try {
                    TimeUnit.SECONDS.sleep(sec);
                } catch (InterruptedException e) {
                    System.out.println(e);
                } finally {
                    System.out.println("Wait for " + sec + " seconds");
                }
            });
        }
        exec.shutdown();
    }
}
