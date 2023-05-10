package leetcode.algorithm1;

import leetcode.utils.ArrayUtils;

import java.util.Arrays;

public class FloodFill733 {

    public static void main(String[] args) {
        final FloodFill733 ffObj = new FloodFill733();
        int[][] area = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] area2 = new int[][]{{0, 1}, {1, 1}};

        ArrayUtils.printMatrix(area);
        System.out.println();
        ffObj.floodFill(area, 3, 4, 3);
        ArrayUtils.printMatrix(area);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final int curColor = image[sr][sc];
        if (color != curColor) {
            fill(image, sr, sc, curColor, color);
        }
        return image;
    }

    public void fill(int[][] img, int sr, int sc, int baseColor, int newColor) {
        int currentColor = img[sr][sc];
        if (currentColor != baseColor) {
            return;
        }
        img[sr][sc] = newColor;
        if (sr < img.length - 1) {
            fill(img, sr + 1, sc, baseColor, newColor);
        }
        if (sr >= 1) {
            fill(img, sr - 1, sc, baseColor, newColor);
        }
        if (sc < img[sr].length - 1) {
            fill(img, sr, sc + 1, baseColor, newColor);
        }
        if (sc >= 1) {
            fill(img, sr, sc - 1, baseColor, newColor);
        }
    }
}
