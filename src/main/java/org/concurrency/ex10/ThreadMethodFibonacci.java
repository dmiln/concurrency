package org.concurrency.ex10;

import org.concurrency.fibonnaci.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMethodFibonacci {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ThreadMethod method = new ThreadMethod();
        final Future<Long> result = method.runTask(15);
        System.out.println(result.get());
    }
}

class ThreadMethod {
    private final  ExecutorService exec;

    public ThreadMethod() {
        exec = Executors.newSingleThreadExecutor();
    }

    public Future<Long> runTask(int count) {
        final Future<Long> submit = exec.submit(new FibSum(count));
        exec.shutdown();
        return submit;
    }
}

class FibSum implements Callable<Long> {

    private final int count;
    private final ExecutorService exec;

    public FibSum(int count) {
        this.count = count;
        exec = Executors.newCachedThreadPool();
    }

    @Override
    public Long call() throws Exception {
        List<Future<Long>> results = new ArrayList<>();

        for (int i = 0; i <= count; i++) {
            int curFibNum = i;
            results.add(exec.submit(() -> Fibonacci.fib(curFibNum)));
        }
        exec.shutdown();

        long sum = 0;
        for (Future<Long> result : results) {
            sum += result.get();
        }

        return sum;
    }
}
