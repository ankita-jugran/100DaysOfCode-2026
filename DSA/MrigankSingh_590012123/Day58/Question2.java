package Day58;

public class Question2 {
    public int countValidPasscodes(int[] tree) {
        if (tree.length == 0 || tree[0] == -1) {
            return 0;
        }
        return dfs(tree, 0, 0);
    }

    private int dfs(int[] tree, int idx, int mask) {
        if (idx >= tree.length || tree[idx] == -1) {
            return 0;
        }

        int digit = tree[idx];
        mask ^= (1 << digit);

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        boolean hasLeft = left < tree.length && tree[left] != -1;
        boolean hasRight = right < tree.length && tree[right] != -1;

        if (!hasLeft && !hasRight) {
            return Integer.bitCount(mask) <= 1 ? 1 : 0;
        }

        int count = 0;
        if (hasLeft) {
            count += dfs(tree, left, mask);
        }
        if (hasRight) {
            count += dfs(tree, right, mask);
        }
        return count;
    }
}
