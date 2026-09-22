package Day62;

public class Question2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxRob(int[] tree) {
        TreeNode root = build(tree, 0);
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
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

    private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        int withNode = node.val + left[1] + right[1];
        int withoutNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{withNode, withoutNode};
    }
}
