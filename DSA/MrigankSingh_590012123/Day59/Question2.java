package Day59;

public class Question2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int countValidPaths(int[] tree) {
        TreeNode root = build(tree, 0);
        return countValidPaths(root, 0);
    }

    private TreeNode build(int[] tree, int idx) {
        if (idx >= tree.length || tree[idx] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(tree[idx]);
        node.left = build(tree, 2 * idx + 1);
        node.right = build(tree, 2 * idx + 2);
        return node;
    }

    private int countValidPaths(TreeNode root, int mask) {
        if (root == null) {
            return 0;
        }

        mask ^= (1 << root.val);

        if (root.left == null && root.right == null) {
            return Integer.bitCount(mask) <= 1 ? 1 : 0;
        }

        return countValidPaths(root.left, mask) + countValidPaths(root.right, mask);
    }
}
