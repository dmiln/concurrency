package org.concurrency.callable;

import org.concurrency.fibonnaci.Fibonacci;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            int val = i;
            results.add(exec.submit(() -> Fibonacci.fib(val)));
        }

        int sum = 0;
        for (Future<Integer> result : results) {
            try {
                sum += result.get();
            } catch (ExecutionException | InterruptedException e) {
                System.out.print(e);            }
            finally {
                exec.shutdown();
            }
        }
        System.out.println(sum);
    }
}
