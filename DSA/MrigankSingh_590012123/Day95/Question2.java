package Day95;

public class Question2 {
    public int maxHappiness(int n, int T, int[] duration, int[] happiness) {
        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {
            for (int time = T; time >= duration[i]; time--) {
                dp[time] = Math.max(dp[time], dp[time - duration[i]] + happiness[i]);
            }
        }

        return dp[T];
    }
}
