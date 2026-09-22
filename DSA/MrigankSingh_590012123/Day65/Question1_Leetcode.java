package Day65;

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

    private boolean hasPrev;
    private int prevVal;
    private int curCount;
    private int maxCount;
    private List<Integer> modes;

    public int[] findMode(TreeNode root) {
        hasPrev = false;
        curCount = 0;
        maxCount = 0;
        modes = new ArrayList<>();

        inorder(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (hasPrev && node.val == prevVal) {
            curCount++;
        } else {
            curCount = 1;
        }

        if (curCount > maxCount) {
            maxCount = curCount;
            modes.clear();
            modes.add(node.val);
        } else if (curCount == maxCount) {
            modes.add(node.val);
        }

        prevVal = node.val;
        hasPrev = true;

        inorder(node.right);
    }
}
