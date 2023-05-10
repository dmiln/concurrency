package leetcode.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Biweekly101 {

    public static void main(String[] args) {
        Biweekly101 bw = new Biweekly101();

        System.out.println((int)'a' -96);
        System.out.println((int)'z' - 96);

        System.out.println(bw.maximumCostSubstring("talaqlt", "tqla", new int[]{4, 3, 3, -2}));
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> costs = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char symb = chars.charAt(i);
            costs.put(symb, vals[i]);
        }

        int max = 0;
        int curSum = max;

        for (int i = 0; i < s.length(); i++) {
            char curSymbol = s.charAt(i);
            int curSymbCost = costs.getOrDefault(curSymbol, curSymbol - 96);
            if (curSymbCost > 0) {
                curSum = curSymbCost + curSum;
                if (max < curSum) {
                    max = curSum;
                }
            } else {
                curSum = 0;
            }
        }

        return max;
    }

    public int minNumber(int[] nums1, int[] nums2) {
        Map<Integer, Integer> unique = new HashMap<>();
        int l = Math.max(nums1.length, nums2.length);
        int minA = nums1[0];
        int minB = nums2[0];
        for (int i = 0; i < l; i++) {
            if (i < nums1.length) {
                int cur = nums1[i];
                unique.merge(cur, 1, Integer::sum);
                if (minA > nums1[i]) {
                    minA = cur;
                }
            }
            if (i < nums2.length) {
                int cur = nums2[i];
                unique.merge(cur, 1, Integer::sum);
                if (minB > nums2[i]) {
                    minB = nums2[i];
                }
            }
        }
        int mapMin = 10;
        for (Map.Entry<Integer, Integer> entry : unique.entrySet()) {
            if (entry.getValue() == 2 && entry.getKey() < mapMin) {
                mapMin = entry.getKey();
            }
        }
        if (mapMin != 10) {
            return mapMin;
        }
        String res = "" + Math.min(minA, minB) + Math.max(minA, minB);
        return Integer.parseInt(res);
    }
}
