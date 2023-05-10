package leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtils {
    public static List<Integer> getListNodeVals(ListNode node) {
        List<Integer> vals = new ArrayList<>();
        ListNode n = node;
        while (n != null) {
            vals.add(n.val);
            n = n.next;
        }
        return vals;
    }
}
