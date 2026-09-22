package Day73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

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

        TreeSet<Integer> unvisited = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                unvisited.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            List<Integer> toRemove = new ArrayList<>();
            for (int v : unvisited) {
                if (!adj[u].contains(v)) {
                    dist[v] = dist[u] + 1;
                    toRemove.add(v);
                    queue.offer(v);
                }
            }
            unvisited.removeAll(toRemove);
        }

        return dist;
    }
}
