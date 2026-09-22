package Day76;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public boolean hasEulerTrailAfterK(int n, int[][] edges, int k) {
        List<int[]> curEdges = new ArrayList<>();
        for (int[] e : edges) {
            curEdges.add(new int[]{e[0], e[1]});
        }
        int curN = n;

        for (int step = 0; step < k; step++) {
            List<List<Integer>> incident = new ArrayList<>();
            for (int i = 0; i <= curN; i++) {
                incident.add(new ArrayList<>());
            }

            for (int i = 0; i < curEdges.size(); i++) {
                int u = curEdges.get(i)[0];
                int v = curEdges.get(i)[1];
                incident.get(u).add(i);
                incident.get(v).add(i);
            }

            List<int[]> nextEdges = new ArrayList<>();
            for (int u = 1; u <= curN; u++) {
                List<Integer> list = incident.get(u);
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        nextEdges.add(new int[]{list.get(i) + 1, list.get(j) + 1});
                    }
                }
            }

            curN = curEdges.size();
            curEdges = nextEdges;
        }

        return hasEulerTrail(curN, curEdges);
    }

    private boolean hasEulerTrail(int n, List<int[]> edges) {
        int[] degree = new int[n + 1];

        for (int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
        }

        int odd = 0;
        for (int i = 1; i <= n; i++) {
            odd += degree[i] & 1;
        }

        return odd == 0 || odd == 2;
    }
}
