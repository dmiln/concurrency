package org.concurrency.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TaskThreeActionTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(new TaskThreeAction());
        }

        executor.shutdown();
    }
}
