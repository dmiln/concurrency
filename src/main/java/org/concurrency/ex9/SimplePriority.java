package org.concurrency.ex9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SimplePriority implements Runnable {

    private int count = 5;
    private volatile double d;

    public String toString() {
        return Thread.currentThread() + ": " + count;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--count == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        final PriorityThreadFactory factory = new PriorityThreadFactory(Thread.MIN_PRIORITY);
        ExecutorService exec = Executors.newCachedThreadPool(factory);
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriority());
        }
        factory.setPriority(Thread.MAX_PRIORITY);
        exec.execute(new SimplePriority());
    }
}

class PriorityThreadFactory implements ThreadFactory {

    private int priority;

    PriorityThreadFactory(int priority) {this.priority = priority;}

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public Thread newThread(Runnable r) {
        final Thread thread = new Thread(r);
        thread.setPriority(priority);
        return thread;
    }
}
