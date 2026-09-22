package Day74;

public class Question1_Leetcode {
    private int[] parent;
    private int[] sz;

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

        for (int[] e : edges) {
            unite(e[0], e[1]);
        }

        long remaining = n;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                ans += (long) sz[i] * (remaining - sz[i]);
                remaining -= sz[i];
            }
        }
        return ans;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (sz[a] < sz[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] = a;
        sz[a] += sz[b];
    }
}
