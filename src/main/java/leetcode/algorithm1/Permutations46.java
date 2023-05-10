package leetcode.algorithm1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations46 {

    public static void main(String[] args) {
        int[] in1 = new int[]{1, 2, 3};

        Permutations46 pO = new Permutations46();
        List<List<Integer>> permute = pO.permute(in1);
        for (List<Integer> permList : permute) {
            System.out.println(permList);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        Arrays.stream(nums).forEach(numList::add);
        permutation(new ArrayList<>(), numList, result);
        return result;
    }

    public void permutation(List<Integer> cur, List<Integer> vals, List<List<Integer>> result) {
        if (vals.isEmpty()) {
            result.add(cur);
            return;
        }
        for (int i = 0; i < vals.size(); i++) {
            ArrayList<Integer> left = new ArrayList<>(vals);
            Integer val = left.remove(i);
            ArrayList<Integer> crList = new ArrayList<>(cur);
            crList.add(val);
            permutation(crList, left, result);
        }
    }
}
