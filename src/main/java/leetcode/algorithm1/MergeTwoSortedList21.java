package leetcode.algorithm1;

import leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.utils.ListNodeUtils.getListNodeVals;

public class MergeTwoSortedList21 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode5;

        listNode2.next = listNode4;
        listNode4.next = listNode6;

        MergeTwoSortedList21 mtO = new MergeTwoSortedList21();
        ListNode node = mtO.mergeTwoLists(listNode1, listNode2);
        List<Integer> listNodeVals = getListNodeVals(node);
        System.out.println(listNodeVals);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode next = null;
        if (list1 != null) {
            if (list2 != null) {
                if (list1.val < list2.val) {
                    next = list1;
                    mergeTwoLists(list1.next, list2, next);
                } else {
                    next = list2;
                    mergeTwoLists(list1, list2.next, next);
                }
            } else {
                next = list1;
                mergeTwoLists(list1.next, null, next);
            }
        } else if (list2 != null) {
            next = list2;
            mergeTwoLists(null, list2.next, next);
        }

        return next;
    }

    public void mergeTwoLists(ListNode list1, ListNode list2, ListNode res) {
        if (list1 != null) {
            if (list2 != null) {
                if (list1.val < list2.val) {
                    res.next = list1;
                    mergeTwoLists(list1.next, list2, res.next);
                } else {
                    res.next = list2;
                    mergeTwoLists(list1, list2.next, res.next);
                }
            } else {
                res.next = list1;
                mergeTwoLists(list1.next, null, res.next);
            }
        } else {
            if (list2 != null) {
                res.next = list2;
                mergeTwoLists(null, list2.next, res.next);
            }
        }
    }
}

