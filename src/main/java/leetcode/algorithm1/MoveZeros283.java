package leetcode.algorithm1;

import java.util.Arrays;

public class MoveZeros283 {

    public static void main(String[] args) {
        int[] ar = new int[]{0,1,0,3,12};
        final MoveZeros283 obj = new MoveZeros283();
        obj.moveZeroes(ar);
        System.out.println(Arrays.toString(ar));
    }

    public void moveZeroes(int[] nums) {
        int[] res = new int[nums.length];

        int j = nums.length - 1;
        int k = 0;
        for (final int num : nums) {
            if (num == 0) {
                res[j--] = num;
            } else {
                res[k++] = num;
            }
        }
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
