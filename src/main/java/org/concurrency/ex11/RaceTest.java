package org.concurrency.ex11;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Race {

    private int sum;
    private int koef;

    public synchronized void increaseSum() {
        ++koef;
        Thread.yield();
        ++koef;
        sum = koef;
        if (sum % 2 != 0) {
            System.out.println("incorrect sum = " + sum);
        }
    }

    public int getSum() {
        return sum;
    }
}

public class RaceTest {

    public static void main(String[] args) {
        final Race race = new Race();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> {
                while (race.getSum() % 2 == 0) {
                    race.increaseSum();
                }
                System.out.println("Exit " + Thread.currentThread()
                                                   .getName() + " with sum " + race.getSum());
            });
        }
        exec.shutdown();
    }
}
