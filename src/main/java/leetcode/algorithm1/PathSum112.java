package leetcode.algorithm1;

import leetcode.utils.TreeNode;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Set<Integer> paths = new HashSet<>();
        currentSum(root, null, paths);
        return paths.contains(targetSum);
    }

    public void currentSum(TreeNode node, Integer current, Set<Integer> paths) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (current != null) {
                paths.add(current + node.val);
            } else {
                paths.add(node.val);
            }
            return;
        }
        if (current == null) {
            current = 0;
        }
        currentSum(node.left, current + node.val, paths);
        currentSum(node.right, current + node.val, paths);
    }

    public int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getSum(node.left);
        int right = getSum(node.right);
        return Math.max(left, right) + node.val;
    }

    int ans = 0;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        getMaxSum(root);
        return ans;
    }

    public int getMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, getMaxSum(node.left));
        int right = Math.max(0, getMaxSum(node.right));

        int cur = left + right + node.val;
        if (ans < cur) {
            ans = cur;
        }
        return Math.max(left, right) + node.val;
    }
}
