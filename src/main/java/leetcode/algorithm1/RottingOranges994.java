package leetcode.algorithm1;

import java.util.LinkedList;

public class RottingOranges994 {

    public static void main(String[] args) {
        int[][] area1 = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};

        int[][] area2 = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}};

        int[][] area3 = new int[][]{
                {2, 0}};

        RottingOranges994 ro = new RottingOranges994();

        System.out.println(ro.orangesRotting(area3));
    }

    public int orangesRotting(int[][] grid) {
        int res = 0;
        int[][] infoMatr = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int rotten = grid[i][j];
                if (rotten == 2) {
                    rotateFromEachRottenOrange(grid, i, j, infoMatr);
                }
            }
        }

        for (int i = 0; i < infoMatr.length; i++) {
            for (int j = 0; j < infoMatr[i].length; j++) {
                int min = infoMatr[i][j];
                if (grid[i][j] == 1 && min == 0) {
                    return -1;
                }
                if (min > res) {
                    res = min;
                }
            }
        }


        return res;
    }

    public void rotateFromEachRottenOrange(int[][] matrix, int xX, int yY, int[][] res) {

        LinkedList<Point> points = new LinkedList<>();

        points.addLast(new Point(xX, yY, 0));

        while (!points.isEmpty()) {
            Point point = points.removeFirst();
            int x = point.x;
            int y = point.y;

            int newDist = point.dist + 1;

            if (y >= 1) {
                int val = matrix[x][y - 1];
                if (val == 1 && (res[x][y - 1] > newDist || res[x][y - 1] == 0) && (x != xX || y - 1 != yY)) {
                    res[x][y - 1] = newDist;
                    points.addLast(new Point(x, y - 1, newDist));
                }
            }

            if (y + 1 < matrix[x].length ) {
                int val = matrix[x][y + 1];
                if (val == 1 && (res[x][y + 1] > newDist || res[x][y + 1] == 0) && (x != xX || y + 1 != yY)) {
                    res[x][y + 1] = newDist;
                    points.addLast(new Point(x, y + 1, newDist));
                }
            }

            if (x >= 1) {
                int val = matrix[x - 1][y];
                if (val == 1 && (res[x - 1][y] > newDist || res[x - 1][y] == 0) && (x - 1 != xX || y != yY)) {
                    res[x - 1][y] = newDist;
                    points.addLast(new Point(x - 1, y, newDist));
                }
            }
            if (x + 1 < matrix.length) {
                int val = matrix[x + 1][y];
                if (val == 1 && (res[x + 1][y] > newDist || res[x + 1][y] == 0) && (x + 1 != xX || y != yY)) {
                    res[x + 1][y] = newDist;
                    points.addLast(new Point(x + 1, y, newDist));
                }
            }
        }
    }

    static class Point {

        int x;
        int y;

        int dist;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
