package leetcode.algorithm1;

import java.util.Arrays;

public class SquaresofaSortedArray977 {

    public static void main(String[] args) {

        int[] a1 = new int[]{-4, -1, 0, 3, 10};
        int[] a2 = new int[]{-7, -5, -3, -2, -1};
        final SquaresofaSortedArray977 sq = new SquaresofaSortedArray977();

        System.out.println(Arrays.toString(sq.sortedSquares(a1)));
        System.out.println(Arrays.toString(sq.sortedSquares(a2)));
    }

    // [-4,-1,0,3,10]
    public int[] sortedSquares(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        int[] res = new int[nums.length];
        int resInd = res.length - 1;

        while (i <= j) {
            final int head = Math.abs(nums[i]);
            final int tail = Math.abs(nums[j]);

            if (head > tail) {
                res[resInd--] = head * head;
                i++;
            } else {
                res[resInd--] = tail * tail;
                j--;
            }
        }

        return res;
    }
}
