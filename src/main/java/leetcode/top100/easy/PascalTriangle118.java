package leetcode.top100.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public static void main(String[] args) {
//        PascalTriangle118 pt = new PascalTriangle118();
//        List<List<Integer>> triangle = pt.generate(10);
//        for (List<Integer> row : triangle) {
//            System.out.println(row);
//        }
        ArrayList<A> list = new ArrayList<>();
        list.add(new AA());
        A a = list.get(0);
        System.out.println(a);

        System.out.printf("%-" + 20 + "s\n", "abcdef");
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < prev.size(); j++) {
                cur.add(prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            res.add(cur);
        }

        return res;
    }
}

class A {

}

class AA extends A {

}
