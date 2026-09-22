package Day96;

import java.util.Arrays;

public class Question2 {
    public long minSignalCost(int n, int[] signal) {
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = signal[i] - signal[j];
                long cost = diff * diff;

                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }

        return dp[n - 1];
    }
}
