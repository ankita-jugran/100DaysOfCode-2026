package Day66;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Question2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int[] mergeEmployeeIds(int[] tree1, int[] tree2) {
        TreeNode r1 = buildTree(tree1);
        TreeNode r2 = buildTree(tree2);

        TreeSet<Integer> ids = new TreeSet<>();
        collect(r1, ids);
        collect(r2, ids);

        int[] result = new int[ids.size()];
        int i = 0;
        for (int id : ids) {
            result[i++] = id;
        }
        return result;
    }

    private TreeNode buildTree(int[] vals) {
        if (vals.length == 0 || vals[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();

            if (i < vals.length) {
                if (vals[i] != -1) {
                    node.left = new TreeNode(vals[i]);
                    queue.offer(node.left);
                }
                i++;
            }
            if (i < vals.length) {
                if (vals[i] != -1) {
                    node.right = new TreeNode(vals[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    private void collect(TreeNode node, TreeSet<Integer> ids) {
        if (node == null) {
            return;
        }
        ids.add(node.val);
        collect(node.left, ids);
        collect(node.right, ids);
    }
}
