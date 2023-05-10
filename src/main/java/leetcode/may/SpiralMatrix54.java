package leetcode.may;

import leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] matr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        SpiralMatrix54 sp = new SpiralMatrix54();
        List<Integer> res = sp.spiralOrder(matr);
        System.out.println(res);

        System.out.println();


        int[][] spiralMatrix = sp.generateMatrix(5);
        ArrayUtils.printMatrix(spiralMatrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int topB = 0;
        int bottomB = matrix.length - 1;
        int leftB = 0;
        int rightB = matrix[0].length - 1;

        List<Integer> res = new ArrayList<>();

        while (leftB <= rightB) {
            for (int i = leftB; i <= rightB && topB <= bottomB; i++) {
                res.add(matrix[topB][i]);
            }
            topB++;
            for (int i = topB; i <= bottomB && leftB <= rightB; i++) {
                res.add(matrix[i][rightB]);
            }
            rightB--;
            for (int i = rightB; i >= leftB && topB <= bottomB; i--) {
                res.add(matrix[bottomB][i]);
            }
            bottomB--;
            for (int i = bottomB; i >= topB && leftB <= rightB; i--) {
                res.add(matrix[i][leftB]);
            }
            leftB++;
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int top = 0;
        int bot = res.length - 1;
        int left = 0;
        int right = res[0].length - 1;

        int counter = 1;

        while (left <= right) {
            for (int i = left; i <= right && top <= bot; i++) {
                res[top][i] = counter++;
            }
            top++;
            for (int i = top; i <= bot && left <= right; i++) {
                res[i][right] = counter++;
            }
            right--;
            for (int i = right; i >= left && top <= bot; i--) {
                res[bot][i] = counter++;
            }
            bot--;
            for (int i = bot; i >= top && left <= right; i--) {
                res[i][left] = counter++;
            }
            left++;
        }

        return res;
    }
}
