package leetcode.algorithm1;

import leetcode.utils.ListNode;

public class RemoveNodeFromList {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 1;

        ListNode node = head;
        while(node.next != null) {
            node = node.next;
            len++;
        }

        int delInd = len - n;

        node = head;
        ListNode prevNode = null;
        while (delInd-- > 0) {
            prevNode = node;
            node = node.next;
        }

        if (prevNode == null) {
            return node.next;
        }

        if (node.next == null) {
            prevNode.next = null;
        } else {
            prevNode.next = node.next;
        }

        return head;
    }
}
