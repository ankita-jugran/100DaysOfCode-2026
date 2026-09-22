package Day69;

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

    private int idx;

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (idx == preorder.length || preorder[idx] < lower || preorder[idx] > upper) {
            return null;
        }

        int val = preorder[idx];
        idx++;

        TreeNode node = new TreeNode(val);
        node.left = build(preorder, lower, val);
        node.right = build(preorder, val, upper);
        return node;
    }
}
