package Day74;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    private List<List<Integer>> adj;
    private boolean[] covered;
    private boolean[] visited;
    private int t;

    public int maxCovered(int n, int t, int[][] edges) {
        this.t = t;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        covered = new boolean[n + 1];
        visited = new boolean[n + 1];

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (covered[i]) {
                total++;
            }
        }
        return total;
    }

    private void dfs(int u, int parent) {
        visited[u] = true;
        List<Integer> availableChildren = new ArrayList<>();

        for (int v : adj.get(u)) {
            if (v == parent || visited[v]) {
                continue;
            }
            dfs(v, u);
            if (!covered[v]) {
                availableChildren.add(v);
            }
        }

        if (!availableChildren.isEmpty()) {
            int k = Math.min(availableChildren.size(), t);
            covered[u] = true;
            for (int i = 0; i < k; i++) {
                covered[availableChildren.get(i)] = true;
            }
        }
    }
}
