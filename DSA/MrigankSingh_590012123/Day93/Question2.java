package Day93;

public class Question2 {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j] + 1;

                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        int middle = (k == i + 1) ? 0 : dp[i + 1][k - 1];
                        dp[i][j] = Math.min(dp[i][j], middle + dp[k][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
