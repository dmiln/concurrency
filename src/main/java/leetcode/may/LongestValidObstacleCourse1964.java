package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Решил с помощью разбора https://www.youtube.com/watch?v=Xq9VT7p0lic
 */
public class LongestValidObstacleCourse1964 {
    public static void main(String[] args) {

        LongestValidObstacleCourse1964 lo = new LongestValidObstacleCourse1964();
        int[] ar = new int[]{5, 1, 5, 5, 1, 3, 4, 5, 1, 4};
        System.out.println(Arrays.toString(lo.longestObstacleCourseAtEachPosition(ar)));
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] result = new int[obstacles.length];
        List<Integer> dp = new ArrayList<>();

        for (int i = 0; i < obstacles.length; i++) {
            int val = obstacles[i];
            int ind = bisectRight(dp, val);
            result[i] = ind + 1;
            if (ind == dp.size()) {
                dp.add(val);
            } else {
                dp.set(ind, val);
            }
        }

        return result;
    }

    public int bisectRight(List<Integer> dp, int target) {
        if (dp.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = dp.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = dp.get(mid);
            if (target < val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
