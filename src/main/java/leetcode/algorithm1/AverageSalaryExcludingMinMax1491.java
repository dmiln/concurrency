package leetcode.algorithm1;

import java.util.concurrent.Executors;

public class AverageSalaryExcludingMinMax1491 {

    public static void main(String[] args) {
    }

    public double average(int[] salary) {
        int sum = 0;
        int min = salary[0], max = salary[0];
        for (int s : salary) {
            min = Math.min(s, min);
            max = Math.max(s, max);
            sum += s;
        }
        sum = sum - min - max;
        return sum * 1.0 / (salary.length - 2);
    }
}
