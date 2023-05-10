package leetcode.may;

public class MatrixDiagonalSum1572 {
    public int diagonalSum(int[][] mat) {
        int l = 0;
        int r = mat[0].length - 1;
        int res = 0;
        for (int[] row : mat) {
            if (l == r) {
                res += row[l];
            } else {
                res += row[l];
                res += row[r];
            }
            l++;
            r--;
        }
        return res;
    }
}
