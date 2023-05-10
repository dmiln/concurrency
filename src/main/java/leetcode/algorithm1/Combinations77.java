package leetcode.algorithm1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations77 {

    public static void main(String[] args) {
        Combinations77 cobj = new Combinations77();

        List<List<Integer>> combine = cobj.combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        if (n == 1) {
            ArrayList<Integer> intList = new ArrayList<>();
            intList.add(1);
            res.add(intList);
        } else {
            comb(null, 1, k, n, res);
        }

        return res;
    }

    public int comb(List<Integer> list, int cur, int k, int n,
            List<List<Integer>> global) {

        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() == k) {
            global.add(list);
            return cur;
        }

        int i = cur;
        while (i <= n) {
            ArrayList<Integer> nextList = new ArrayList<>(list);
            nextList.add(i);
            i = comb(nextList, i + 1, k, n, global);
        }

        return cur;
    }
}
