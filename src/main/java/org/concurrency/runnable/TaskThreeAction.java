package org.concurrency.runnable;

public class TaskThreeAction implements Runnable {

    public TaskThreeAction() {
        System.out.println("Create task");
    }

    public void run() {
        System.out.println("1 message");
        Thread.yield();
        System.out.println("2 message");
        Thread.yield();
        System.out.println("3 message");
        Thread.yield();
    }
}
