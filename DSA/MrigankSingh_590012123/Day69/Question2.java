package Day69;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    static class TreeNode {
        long val;
        TreeNode left;
        TreeNode right;
        TreeNode(long val) {
            this.val = val;
        }
    }

    public long[][] splitBST(long[] arr, long k) {
        int n = arr.length - 1;
        TreeNode root = build(arr, 1, n);
        TreeNode[] branches = split(root, k);

        List<Long> branchA = new ArrayList<>();
        List<Long> branchB = new ArrayList<>();
        preorder(branches[0], branchA);
        preorder(branches[1], branchB);

        return new long[][]{toArray(branchA), toArray(branchB)};
    }

    private TreeNode build(long[] arr, int i, int n) {
        if (i > n || i < 1 || arr[i] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(arr[i]);
        node.left = build(arr, 2 * i, n);
        node.right = build(arr, 2 * i + 1, n);
        return node;
    }

    private TreeNode[] split(TreeNode root, long k) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < k) {
            TreeNode[] parts = split(root.right, k);
            root.right = parts[0];
            return new TreeNode[]{root, parts[1]};
        } else {
            TreeNode[] parts = split(root.left, k);
            root.left = parts[1];
            return new TreeNode[]{parts[0], root};
        }
    }

    private void preorder(TreeNode node, List<Long> out) {
        if (node == null) {
            return;
        }
        out.add(node.val);
        preorder(node.left, out);
        preorder(node.right, out);
    }

    private long[] toArray(List<Long> list) {
        long[] arr = new long[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
