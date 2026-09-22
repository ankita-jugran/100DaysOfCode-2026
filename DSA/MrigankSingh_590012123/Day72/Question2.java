package Day72;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Question2 {
    public int[] chaseDistances(int n, int[][] mainRoads, int s) {
        Set<Integer>[] adj = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] road : mainRoads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[s] = 0;

        int[] nxt = new int[n + 2];
        int[] prv = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            nxt[i] = i + 1;
            prv[i] = i - 1;
        }
        nxt[0] = 1;
        prv[n + 1] = n;

        unlink(nxt, prv, s);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = nxt[0];
            while (v != n + 1) {
                int nextV = nxt[v];
                if (!adj[u].contains(v)) {
                    unlink(nxt, prv, v);
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
                v = nextV;
            }
        }

        return dist;
    }

    private void unlink(int[] nxt, int[] prv, int v) {
        nxt[prv[v]] = nxt[v];
        prv[nxt[v]] = prv[v];
    }
}
