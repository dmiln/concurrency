package org.concurrency.fibonnaci;

public class Fibonacci {

    public static void main(String[] args) {
        final long res = fib(30);
        System.out.println(res);
    }

    public static long fib(int n) {
        long first = 0;
        long second = first;

        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                second = 1;
                continue;
            }
            long tmp = first;
            first = second;
            second = tmp + first;
            sb.append(" ").append(first);
        }

        if (first != second) {
            sb.append(" ").append(second);
        }

        System.out.println(sb);
        return second;
    }
}
