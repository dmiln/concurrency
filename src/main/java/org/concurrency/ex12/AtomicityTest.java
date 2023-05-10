package org.concurrency.ex12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicityTest atomicityTest = new AtomicityTest();
        exec.execute(atomicityTest);
        exec.shutdown();
        while (true) {
            int val = atomicityTest.getValue();
            if (val < 0) {
                System.out.println("Success");
                System.exit(0);
            }
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
