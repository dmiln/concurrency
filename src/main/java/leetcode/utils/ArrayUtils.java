package leetcode.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static int[] createRandomArray(int size, int range) {
        int[] res = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            res[i] = random.nextInt(range * 2) - range;
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, res[i], 0, matrix[i].length);
        }
        return res;
    }
}
