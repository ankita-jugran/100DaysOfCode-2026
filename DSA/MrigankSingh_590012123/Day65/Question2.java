package Day65;

public class Question2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int closestValue(int[] tree, double target) {
        TreeNode root = build(tree, tree.length, 1);

        int best = root.val;
        double bestDiff = Math.abs(root.val - target);

        TreeNode cur = root;
        while (cur != null) {
            double diff = Math.abs(cur.val - target);
            if (diff < bestDiff || (diff == bestDiff && cur.val < best)) {
                best = cur.val;
                bestDiff = diff;
            }

            if (target < cur.val) {
                cur = cur.left;
            } else if (target > cur.val) {
                cur = cur.right;
            } else {
                break;
            }
        }
        return best;
    }

    private TreeNode build(int[] tree, int n, int pos) {
        if (pos > n || tree[pos - 1] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(tree[pos - 1]);
        node.left = build(tree, n, 2 * pos);
        node.right = build(tree, n, 2 * pos + 1);
        return node;
    }
}
