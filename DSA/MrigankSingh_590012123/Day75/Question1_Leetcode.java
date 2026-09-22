package Day75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question1_Leetcode {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        int[][] count = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int ans = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;

            int c = colors.charAt(u) - 'a';
            count[u][c]++;
            ans = Math.max(ans, count[u][c]);

            for (int v : adj.get(u)) {
                for (int k = 0; k < 26; k++) {
                    count[v][k] = Math.max(count[v][k], count[u][k]);
                }
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == n ? ans : -1;
    }
}
