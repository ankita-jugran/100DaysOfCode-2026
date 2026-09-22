package Day67;

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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode succParent = root;
            TreeNode succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if (succParent != root) {
                succParent.left = succ.right;
                succ.right = root.right;
            }
            succ.left = root.left;
            return succ;
        }
        return root;
    }
}
