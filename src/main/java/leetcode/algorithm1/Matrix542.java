package leetcode.algorithm1;

import leetcode.utils.ArrayUtils;
import tinkcont.MainScan;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Matrix542 {

    public static void main(String[] args) {
        int[][] area1 = new int[][]{{0, 1}, {1, 1}};
        int[][] area2 = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] area3 = new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        };
        int[][] area4 = new int[][]{
                {0,0,1,0,1,1,1,0,1,1},
                {1,1,1,1,0,1,1,1,1,1},
                {1,1,1,1,1,0,0,0,1,1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
        };
        int[][] area5 = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}};
        Matrix542 matrix542 = new Matrix542();

        int[][] test = area4;

        int[][] res = matrix542.updateMatrix(test);
        ArrayUtils.printMatrix(test);
        System.out.println();
        ArrayUtils.printMatrix(res);
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    findNearestQueueVers(mat, i, j, res);
                }
            }
        }
        return res;
    }

    //Passed, but nt the best variant (if compare with others)
    public void findNearestQueueVers(int[][] matrix, int xX, int yY, int[][] res) {

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

    //Passed 49/50
    public int findNearestQueueVers(int[][] matrix, int xX, int yY) {
        int[][] v = new int[matrix.length][matrix[xX].length];

        LinkedList<Point> points = new LinkedList<>();

        points.addLast(new Point(xX, yY));

        while (!points.isEmpty()) {
            Point point = points.removeFirst();
            int x = point.x;
            int y = point.y;
            int dist = v[point.x][point.y];

            int d = dist + 1;
            if (y >= 1) {
                int nextDist = v[x][y - 1];
                if ((nextDist == 0 || nextDist > d) && (x != xX || y - 1 != yY)) {
                    if (matrix[x][y - 1] == 0) {
                        return d;
                    }
                    v[x][y - 1] = d;
                    points.addLast(new Point(x, y - 1));
                }
            }

            if (y + 1 < matrix[x].length) {
                int nextDist = v[x][y + 1];
                if ((nextDist == 0 || nextDist > d) && (x != xX || y + 1 != yY)) {
                    if (matrix[x][y + 1] == 0) {
                        return d;
                    }
                    v[x][y + 1] = d;
                    points.addLast(new Point(x, y + 1));
                }
            }

            if (x >= 1) {
                int nextDist = v[x - 1][y];
                if ((nextDist == 0 || nextDist > d) && (x - 1 != xX || y != yY)) {
                    if (matrix[x - 1][y] == 0) {
                        return d;
                    }
                    v[x - 1][y] = d;
                    points.addLast(new Point(x - 1, y));
                }
            }
            if (x + 1 < matrix.length) {
                int nextDist = v[x + 1][y];
                if ((nextDist == 0 || nextDist > d) && (x + 1 != xX || y != yY)) {
                    if (matrix[x + 1][y] == 0) {
                        return d;
                    }
                    v[x + 1][y] = d;
                    points.addLast(new Point(x + 1, y));
                }
            }
        }

        return 0;
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


    // 49/50 passed
    public int findNearestQueueVers1(int[][] matrix, int xX, int yY) {
        int[][] v = new int[matrix.length][matrix[xX].length];

        LinkedList<Point> points = new LinkedList<>();

        points.addLast(new Point(xX, yY));

        while (!points.isEmpty()) {
            Point point = points.removeFirst();
            int x = point.x;
            int y = point.y;
            int dist = v[point.x][point.y];
            if (matrix[point.x][point.y] == 0) {
                return dist;
            }

            if (y >= 1) {
                int nextDist = v[x][y - 1];
                if (nextDist == 0 || nextDist > dist + 1) {
                    v[x][y - 1] = dist + 1;
                    points.addLast(new Point(x, y -1));
                }
            }

            if (y + 1 < matrix[x].length) {
                int nextDist = v[x][y + 1];
                if (nextDist == 0 || nextDist > dist + 1) {
                    v[x][y + 1] = dist + 1;
                    points.addLast(new Point(x, y + 1));
                }
            }

            if (x >= 1) {
                int nextDist = v[x - 1][y];
                if (nextDist == 0 || nextDist > dist + 1) {
                    v[x - 1][y] = dist + 1;
                    points.addLast(new Point(x - 1, y));
                }
            }
            if (x + 1 < matrix.length) {
                int nextDist = v[x + 1][y];
                if (nextDist == 0 || nextDist > dist + 1) {
                    v[x + 1][y] = dist + 1;
                    points.addLast(new Point(x + 1, y));
                }
            }
        }

        return 0;
    }


    public int findNearest0(int[][] matrix, int x, int y, int currentDistance) {
        int maxVal = matrix.length + matrix[x].length;
        if (currentDistance > maxVal) {
            return maxVal;
        }

        int value = matrix[x][y];
        if (value == 0) {
            return currentDistance;
        }

        int leftDist = maxVal;
        int rightDist = maxVal;
        int topDist = maxVal;
        int bottomDist = maxVal;

        int nextDistance = currentDistance + 1;
        if (y >= 1) {
            leftDist = findNearest0(matrix, x, y - 1, nextDistance);
        }
        if (leftDist == nextDistance) {
            return leftDist;
        }
        if (y + 1 < matrix[x].length) {
            rightDist = findNearest0(matrix, x, y + 1, nextDistance);
        }
        if (rightDist == currentDistance) {
            return rightDist;
        }
        if (x >= 1) {
            topDist = findNearest0(matrix, x - 1, y, nextDistance);
        }
        if (topDist == currentDistance) {
            return topDist;
        }
        if (x + 1 < matrix.length) {
            bottomDist = findNearest0(matrix, x + 1, y, nextDistance);
        }
        if (bottomDist == currentDistance) {
            return bottomDist;
        }

        return Math.min(Math.min(leftDist, rightDist), Math.min(topDist, bottomDist));
    }

    //Slow, not passed some big tests
    public void findNearest0WorkerdVersion1(int[][] matrix, int x, int y, int[][] v, Set<Integer> distSet) {
        int value = matrix[x][y];
        int curDist = v[x][y];
        if (value == 0) {
            distSet.add(curDist);
            return;
        }

        if (y >= 1) {
            int nextDist = v[x][y - 1];
            if (nextDist == 0 || nextDist > curDist + 1) {
                v[x][y - 1] = curDist + 1;
                findNearest0WorkerdVersion1(matrix, x, y - 1, v, distSet);
            }
        }

        if (y + 1 < matrix[x].length) {
            int nextDist = v[x][y + 1];
            if (nextDist == 0 || nextDist > curDist + 1) {
                v[x][y + 1] = curDist + 1;
                findNearest0WorkerdVersion1(matrix, x, y + 1, v, distSet);
            }
        }

        if (x >= 1) {
            int nextDist = v[x - 1][y];
            if (nextDist == 0 || nextDist > curDist + 1) {
                v[x - 1][y] = curDist + 1;
                findNearest0WorkerdVersion1(matrix, x - 1, y, v, distSet);
            }
        }
        if (x + 1 < matrix.length) {
            int nextDist = v[x + 1][y];
            if (nextDist == 0 || nextDist > curDist + 1) {
                v[x + 1][y] = curDist + 1;
                findNearest0WorkerdVersion1(matrix, x + 1, y, v, distSet);
            }
        }
    }
}
