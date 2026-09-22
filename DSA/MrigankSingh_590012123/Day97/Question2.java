package Day97;

public class Question2 {
    public int maxEnergy(int n, int[] energy) {
        int prev2 = energy[0];
        int prev1 = energy[0] + energy[1];

        for (int i = 2; i < n; i++) {
            int current = energy[i] + Math.max(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
