package leetcode.algorithm1;

import leetcode.utils.ListNode;
import leetcode.utils.ListNodeUtils;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode node = rll.reverseList(listNode1);
        System.out.println(ListNodeUtils.getListNodeVals(node));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseLinkedList(head, head.next);
    }

    public ListNode reverseLinkedList(ListNode node, ListNode next) {
        if (next == null) {
            return node;
        }

        ListNode n = next.next;
        next.next = node;

        if (node.next == next) {
            node.next = null;
        }

        return reverseLinkedList(next, n);
    }
}
