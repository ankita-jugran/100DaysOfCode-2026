package Day60;

public class Question2 {
    private int count;

    public int countSafeCampsites(int[] tree) {
        count = 0;
        if (tree.length == 0 || tree[0] == -1) {
            return 0;
        }

        dfs(tree, 0, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(int[] tree, int idx, int maxSoFar) {
        if (idx >= tree.length || tree[idx] == -1) {
            return;
        }

        int val = tree[idx];
        int newMax;

        if (val >= maxSoFar) {
            count++;
            newMax = val;
        } else {
            newMax = maxSoFar;
        }

        dfs(tree, 2 * idx + 1, newMax);
        dfs(tree, 2 * idx + 2, newMax);
    }
}
