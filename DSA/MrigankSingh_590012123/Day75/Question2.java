package Day75;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public long minCostRing(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        long totalCost = 0;

        for (int[] road : roads) {
            int a = road[0], b = road[1], c = road[2];
            adj.get(a).add(new int[]{b, 1, c});
            adj.get(b).add(new int[]{a, -1, c});
            totalCost += c;
        }

        int cur = 1, prev = -1;
        long costClockwise = 0;

        for (int step = 0; step < n; step++) {
            for (int[] r : adj.get(cur)) {
                int v = r[0], sign = r[1], cost = r[2];
                if (v == prev) {
                    continue;
                }
                if (sign == -1) {
                    costClockwise += cost;
                }
                prev = cur;
                cur = v;
                break;
            }
        }

        return Math.min(costClockwise, totalCost - costClockwise);
    }
}
