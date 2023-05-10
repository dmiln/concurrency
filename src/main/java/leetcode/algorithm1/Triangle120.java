package leetcode.algorithm1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle120 {

    public static void main(String[] args) {
        //[2],[3,4],[6,5,7],[4,1,8,3]
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(2);
        ArrayList<Integer> secondRow = new ArrayList<>();
        secondRow.add(3);
        secondRow.add(4);
        ArrayList<Integer> thirdRow = new ArrayList<>();
        thirdRow.add(6);
        thirdRow.add(5);
        thirdRow.add(7);
        ArrayList<Integer> fourthRow = new ArrayList<>();
        fourthRow.add(4);
        fourthRow.add(1);
        fourthRow.add(8);
        fourthRow.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(firstRow);
        triangle.add(secondRow);
        triangle.add(thirdRow);
        triangle.add(fourthRow);
        Triangle120 tr = new Triangle120();

        List<Integer> a = new ArrayList<>();
        a.add(-10);
        List<List<Integer>> b = new ArrayList<>();
        b.add(a);

        //[-1],[2,3],[1,-1,-3]
        List<Integer> a1 = new ArrayList<>();
        a1.add(-1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(2);
        a2.add(3);
        List<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(-1);
        a3.add(-3);
        List<List<Integer>> b1 = new ArrayList<>();
        b1.add(a1);
        b1.add(a2);
        b1.add(a3);

        System.out.println(tr.minimumTotal(b1));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] matrix = new int[2][triangle.get(triangle.size() - 1).size()];
        matrix[0][0] = triangle.get(0).get(0);
        for (int j = 1; j < triangle.size(); j++) {
            List<Integer> row = triangle.get(j);
            for (int i = 0; i < row.size(); i++) {
                int minTopPath = 0;
                int prevRowIndex = (j - 1) % 2;
                if (i - 1 >= 0) {
                    int leftParent = matrix[prevRowIndex][i - 1];
                    if (i < row.size() - 1) {
                        int rightParent = matrix[prevRowIndex][i];
                        minTopPath = Math.min(leftParent, rightParent);
                    } else {
                        minTopPath = leftParent;
                    }
                } else {
                    if (i < row.size() - 1) {
                        minTopPath = matrix[prevRowIndex][i];
                    }
                }

                matrix[j % 2][i] = minTopPath + row.get(i);
            }
        }
        int min = matrix[(triangle.size() - 1) % 2][0];
        for (Integer value : matrix[(triangle.size() - 1) % 2]) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public int minimumTotalWorks(List<List<Integer>> triangle) {
        Map<Integer, Integer> topPaths = new HashMap<>();
        topPaths.put(0, triangle.get(0).get(0));
        for (int j = 1; j < triangle.size(); j++) {
            List<Integer> row = triangle.get(j);
            Map<Integer, Integer> rowPaths = new HashMap<>();
            for (int i = 0; i < row.size(); i++) {
                int minTop = 0;
                Integer rightParent = topPaths.get(i);
                Integer leftParent = topPaths.get(i - 1);
                if (rightParent != null && leftParent != null) {
                    minTop = Math.min(leftParent, rightParent);
                } else {
                    if (rightParent != null) {
                        minTop = rightParent;
                    } else {
                        if (leftParent != null) {
                            minTop = leftParent;
                        }
                    }
                }
                rowPaths.put(i, minTop + row.get(i));
            }
            topPaths.clear();
            topPaths.putAll(rowPaths);
        }

        int min = topPaths.get(0);
        for (Integer value : topPaths.values()) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
