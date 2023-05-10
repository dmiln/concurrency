package leetcode.algorithm1;

import java.util.Arrays;

public class RotateArray189 {

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 4, 5, 6};
        final int[] nums2 = {-1,-100,3,99};
        final RotateArray189 rotateArray189 = new RotateArray189();

        System.out.println(Arrays.toString(nums));
        rotateArray189.rotateOZero(nums, 2);
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(nums2));
        rotateArray189.rotateOZero(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }

    //nums = [1,2,3,4,5,6,7], k = 3
    //out = [5,6,7,1,2,3,4]

    //nums = [1,2,3,4,5,6,7,8], k = 2
    //out = [7,8,1,2,3,4,5,6]
    public void rotateSimple(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = (i + k) % nums.length;
            res[j] = nums[i];
        }
        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }

    public void rotateOZero(int[] nums, int k) {
        int len = nums.length;
        int cur = nums[0];
        int ind = 0;

        int visited = ind;
        int nextInd;
        int nextVal;

        while (len > 0) {
            nextInd = (ind + k) % nums.length;
            if (nextInd == visited) {
                nums[nextInd] = cur;
                ind = ++visited;
                if (ind < nums.length) {
                    cur = nums[ind];
                }
            } else {
                nextVal = nums[nextInd];
                nums[nextInd] = cur;
                cur = nextVal;
                ind = nextInd;
            }
            len--;
        }
    }

//    public void rotateOZero1(int[] nums, int k) {
//        int len = nums.length;
//        int cur = nums[0];
//        int ind = 0;
//        while (len > 0) {
//            int nextInd = (ind + k) % nums.length;
//            int nextVal = nums[nextInd];
//            nums[nextInd] = cur;
//            cur = nextVal;
//            ind = nextInd;
//            len--;
//        }
//    }

}
