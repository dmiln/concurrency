package leetcode.may;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceTwoArrays2215 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        for (int i : nums1) {
            left.add(i);
        }
        for (int i : nums2) {
            right.add(i);
        }
        List<Integer> resL = new ArrayList<>();
        List<Integer> resR = new ArrayList<>();
        for (Integer i : left) {
            if (!right.contains(i)) {
                resL.add(i);
            }
        }
        for (Integer i : right) {
            if (!left.contains(i)) {
                resR.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(resL);
        res.add(resR);
        return res;
    }
}
