package Day73;

import java.util.Arrays;

public class Question1_Leetcode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = bfsDist(node1, edges);
        int[] dist2 = bfsDist(node2, edges);

        int n = edges.length;
        int best = -1;
        int bestDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] == -1 || dist2[i] == -1) {
                continue;
            }
            int d = Math.max(dist1[i], dist2[i]);
            if (d < bestDist) {
                bestDist = d;
                best = i;
            }
        }
        return best;
    }

    private int[] bfsDist(int start, int[] edges) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        int cur = start;
        while (edges[cur] != -1 && dist[edges[cur]] == -1) {
            dist[edges[cur]] = dist[cur] + 1;
            cur = edges[cur];
        }
        return dist;
    }
}
