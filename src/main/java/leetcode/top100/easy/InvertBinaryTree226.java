package leetcode.top100.easy;

import leetcode.utils.TreeNode;

public class InvertBinaryTree226 {

    public static void main(String[] args) {
        System.out.println(1 << 10);
    }

    public TreeNode invertTree(TreeNode root) {
        swapChildren(root);
        return root;
    }

    public void swapChildren(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        swapChildren(node.left);
        swapChildren(node.right);
    }
}
