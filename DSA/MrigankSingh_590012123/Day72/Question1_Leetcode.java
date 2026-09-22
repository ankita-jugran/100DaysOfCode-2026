package Day72;

import java.util.Arrays;

public class Question1_Leetcode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        int cur = node1, d = 0;
        while (cur != -1 && dist1[cur] == -1) {
            dist1[cur] = d++;
            cur = edges[cur];
        }

        cur = node2;
        d = 0;
        while (cur != -1 && dist2[cur] == -1) {
            dist2[cur] = d++;
            cur = edges[cur];
        }

        int best = -1;
        long bestMax = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] == -1 || dist2[i] == -1) {
                continue;
            }
            long m = Math.max(dist1[i], dist2[i]);
            if (m < bestMax) {
                bestMax = m;
                best = i;
            }
        }
        return best;
    }
}
