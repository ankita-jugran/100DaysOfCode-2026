package Day76;

import java.util.ArrayList;
import java.util.List;

public class Question1_Leetcode {
    private static final long MOD = 1000000007L;

    private List<List<Integer>> tree;
    private long[] fact;
    private long[] invFact;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree.get(prevRoom[i]).add(i);
        }

        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        return (int) dfs(0)[1];
    }

    private long modPow(long a, long e) {
        long ans = 1;
        while (e > 0) {
            if ((e & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            e >>= 1;
        }
        return ans;
    }

    private long combination(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private long[] dfs(int u) {
        long totalSize = 1;
        long ways = 1;

        for (int v : tree.get(u)) {
            long[] child = dfs(v);
            long childSize = child[0];
            long childWays = child[1];

            ways = ways * childWays % MOD;
            ways = ways * combination((int) (totalSize + childSize - 1), (int) childSize) % MOD;

            totalSize += childSize;
        }

        return new long[]{totalSize, ways};
    }
}
