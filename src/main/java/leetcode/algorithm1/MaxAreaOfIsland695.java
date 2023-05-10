package leetcode.algorithm1;

public class MaxAreaOfIsland695 {

    public static void main(String[] args) {
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

        System.out.println(maxAreaOfIsland(area));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int start = grid[i][j];
                if (start == 1) {
                    int tmp = findIslandArea(grid, i, j);
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
        }

        return max;
    }

    public static int findIslandArea(int[][] area, int i, int j) {
        int isIsland = area[i][j];
        if (isIsland == 0) {
            return 0;
        }

        area[i][j] = 0;

        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;

        if (j >= 1) {
            left = findIslandArea(area, i, j - 1);
        }
        if (j + 1 < area[i].length) {
            right = findIslandArea(area, i, j + 1);
        }
        if (i >= 1) {
            top = findIslandArea(area, i - 1, j);
        }
        if (i + 1 < area.length) {
            bottom = findIslandArea(area, i + 1, j);
        }
        return 1 + left + right + top + bottom;
    }
}
