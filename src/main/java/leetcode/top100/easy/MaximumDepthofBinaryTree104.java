package leetcode.top100.easy;

import leetcode.utils.TreeNode;

public class MaximumDepthofBinaryTree104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        int[] max = new int[1];
        findMaxDepth(root, 0, max);
        return max[0];
    }

    public void findMaxDepth(TreeNode node, int lvl, int[] depth) {
        if (node == null) {
            int curMax = depth[0];
            if (curMax < lvl) {
                depth[0] = lvl;
            }
            return;
        }

        findMaxDepth(node.left, lvl + 1, depth);
        findMaxDepth(node.right, lvl + 1, depth);
    }
}
