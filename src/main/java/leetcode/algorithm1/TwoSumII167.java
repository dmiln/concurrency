package leetcode.algorithm1;

import java.util.Arrays;

public class TwoSumII167 {

    public static void main(String[] args) {
        int[] t1 = new int[]{2, 7, 11, 15};
        int[] t2 = new int[]{2, 3, 4};
        int[] t3 = new int[]{-1, 0};

        final TwoSumII167 tso = new TwoSumII167();
        System.out.println(Arrays.toString(tso.twoSum(t1, 9)));
        System.out.println(Arrays.toString(tso.twoSum(t2, 6)));
        System.out.println(Arrays.toString(tso.twoSum(t3, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        boolean wasFound = false;
        int goal, j, k, mid;
        for (int i = 0; i < numbers.length; i++) {
            goal = target - numbers[i];

            j = i + 1;
            k = numbers.length - 1;
            while (j <= k) {
                mid = (k - j) / 2 + j;
                if (numbers[mid] < goal) {
                    j = mid + 1;
                } else {
                    if (numbers[mid] > goal) {
                        k = mid - 1;
                    } else {
                        res[0] = i + 1;
                        res[1] = mid + 1;
                        wasFound = true;
                        break;
                    }
                }
            }
            if (wasFound) {
                break;
            }
        }

        return res;
    }
}
