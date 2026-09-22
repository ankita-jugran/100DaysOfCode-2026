package Day64;

public class Question2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int lowestCommonAncestor(int[] tree, int a, int b) {
        TreeNode root = build(tree, 0);

        TreeNode cur = root;
        while (cur != null) {
            if (a < cur.val && b < cur.val) {
                cur = cur.left;
            } else if (a > cur.val && b > cur.val) {
                cur = cur.right;
            } else {
                return cur.val;
            }
        }
        return -1;
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
}
