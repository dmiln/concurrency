package leetcode.algorithm1;

import leetcode.utils.TreeNode;

public class MergeTwoBinaryTrees617 {

    public static void main(String[] args) {
        MergeTwoBinaryTrees617 mtbt = new MergeTwoBinaryTrees617();

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = null;
        if (root1 == null && root2 == null) {
            return res;
        }
        res = new TreeNode();
        recursiveNodeMerge(res, root1, root2);
        return res;
    }

    public void recursiveNodeMerge(TreeNode treeNode, TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        if (node1 == null) {
            treeNode.val = node2.val;
            treeNode.left = node2.left;
            treeNode.right = node2.right;
        } else if (node2 == null) {
            treeNode.val = node1.val;
            treeNode.left = node1.left;
            treeNode.right = node1.right;
        } else {
            treeNode.val = node1.val + node2.val;
            if (node1.left != null || node2.left != null) {
                treeNode.left = new TreeNode();
                recursiveNodeMerge(treeNode.left, node1.left, node2.left);
            }
            if (node1.right != null || node2.right != null) {
                treeNode.right = new TreeNode();
                recursiveNodeMerge(treeNode.right, node1.right, node2.right);
            }
        }
    }

}

