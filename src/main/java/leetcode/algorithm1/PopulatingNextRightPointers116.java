package leetcode.algorithm1;

import leetcode.utils.Node;

public class PopulatingNextRightPointers116 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        root.next = null;
        visitAllLeaves(root);
        return root;
    }

    public void visitAllLeaves(Node node) {
        if (node.left == null) {
            return;
        }
        node.left.next = node.right;
        Node next = node.next;
        if (next != null) {
            node.right.next = next.left;
        } else {
            node.right.next = null;
        }

        visitAllLeaves(node.left);
        visitAllLeaves(node.right);
    }
}

