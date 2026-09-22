package Day94;

import java.util.Arrays;

public class Question2 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] allCuts = new int[m + 2];
        System.arraycopy(cuts, 0, allCuts, 0, m);
        allCuts[m] = 0;
        allCuts[m + 1] = n;
        Arrays.sort(allCuts);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    int cost = allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}
