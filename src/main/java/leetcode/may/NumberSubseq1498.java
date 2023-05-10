package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSubseq1498 {
    public static void main(String[] args) {
        int[] ar = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        NumberSubseq1498 ns1 = new NumberSubseq1498();
        System.out.println(ns1.numSubseq(ar, 22));
    }

    int count = 0;

    public int numSubseqLog(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int sum = val + val;
            ArrayList<Integer> l = new ArrayList<>();
            l.add(val);
            if (sum <= target) {
                count++;
                System.out.printf("%s min=%d, max=%d, sum=%d%n", l, val, val, sum);
            }
            calculateSubsequence(nums, i + 1, val, val, target, l);
        }
        return count;
    }

    void calculateSubsequence(int[] nums, int ind, int min, int max, int target,
            List<Integer> list) {
        for (int i = ind; i < nums.length; i++) {
            int val = nums[i];
            int minLoc = Math.min(min, val);
            int maxLoc = Math.max(max, val);
            int sum = minLoc + maxLoc;
            if (sum <= target) {
                count++;
            }
            ArrayList<Integer> l = new ArrayList<>(list);
            l.add(val);
            System.out.printf("%s min=%d, max=%d, sum=%d%n", l, minLoc, maxLoc, sum);
            calculateSubsequence(nums, i + 1, minLoc, maxLoc, target, l);
        }
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int)Math.pow(10, 9) + 7;

        int len = nums.length;
        int[] power = new int[len];
        power[0] = 1;
        for (int i = 1; i < len; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int res = 0;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
