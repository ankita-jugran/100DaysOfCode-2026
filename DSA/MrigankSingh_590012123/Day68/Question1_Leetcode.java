package Day68;

import java.util.ArrayList;
import java.util.List;

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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return buildBalanced(values, 0, values.size() - 1);
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    private TreeNode buildBalanced(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBalanced(values, left, mid - 1);
        node.right = buildBalanced(values, mid + 1, right);
        return node;
    }
}
