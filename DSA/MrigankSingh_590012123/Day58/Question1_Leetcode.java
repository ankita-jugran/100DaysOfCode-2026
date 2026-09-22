package Day58;

import java.util.LinkedList;
import java.util.Queue;

public class Question1_Leetcode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                seenNull = true;
                continue;
            }
            if (seenNull) {
                return false;
            }

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return true;
    }
}
