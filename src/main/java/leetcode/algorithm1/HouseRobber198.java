package leetcode.algorithm1;

import java.util.Map;

public class HouseRobber198 {

    public static void main(String[] args) {
        HouseRobber198 hsr = new HouseRobber198();

        int[] testAr1 = {2, 7, 9, 3, 1};
        System.out.println(hsr.robOptimized(testAr1));
    }

    public int robOptimized(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] res = new int[2];
        int val0 = nums[0];
        int val1 = nums[1];
        res[0] = val0;
        res[1] = Math.max(val0, val1);
        for (int i = 2; i < nums.length; i++) {
            int curVal = nums[i];
            int availMax = res[0];
            int prevMax = res[1];
            int availSum = curVal + availMax;
            res[0] = prevMax;
            res[1] = Math.max(availSum, prevMax);
        }

        return res[1];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] res = new int[nums.length];
        int val0 = nums[0];
        int val1 = nums[1];
        res[0] = val0;
        res[1] = Math.max(val0, val1);
        for (int i = 2; i < nums.length; i++) {
            int curVal = nums[i];
            int availMax = res[i - 2];
            int prevMax = res[i - 1];
            int availSum = curVal + availMax;
            res[i] = Math.max(availSum, prevMax);
        }

        return res[nums.length - 1];
    }
}
