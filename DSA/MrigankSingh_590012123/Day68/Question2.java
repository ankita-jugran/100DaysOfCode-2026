package Day68;

public class Question2 {
    static class TreeNode {
        long val;
        TreeNode left;
        TreeNode right;
        TreeNode(long val) {
            this.val = val;
        }
    }

    static class Info {
        boolean isBST;
        long minVal;
        long maxVal;
        int size;

        Info(boolean isBST, long minVal, long maxVal, int size) {
            this.isBST = isBST;
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.size = size;
        }
    }

    private int best;

    public int largestBSTSubtree(long[] arr) {
        int n = arr.length - 1;
        TreeNode root = build(arr, 1, n);
        best = 0;
        largestBSTHelper(root);
        return best;
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

    private Info largestBSTHelper(TreeNode root) {
        if (root == null) {
            return new Info(true, Long.MAX_VALUE, Long.MIN_VALUE, 0);
        }

        Info left = largestBSTHelper(root.left);
        Info right = largestBSTHelper(root.right);

        if (left.isBST && right.isBST && root.val > left.maxVal && root.val < right.minVal) {
            int size = left.size + right.size + 1;
            best = Math.max(best, size);
            return new Info(true, Math.min(root.val, left.minVal), Math.max(root.val, right.maxVal), size);
        }

        return new Info(false, 0, 0, 0);
    }
}
